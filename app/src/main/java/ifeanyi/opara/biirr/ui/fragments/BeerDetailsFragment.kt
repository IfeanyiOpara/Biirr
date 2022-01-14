package ifeanyi.opara.biirr.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import ifeanyi.opara.biirr.R
import ifeanyi.opara.biirr.databinding.FragmentBeerDetailsBinding
import ifeanyi.opara.biirr.ui.viewModel.BeerDetailsViewModel
import ifeanyi.opara.biirr.ui.viewModel.BeerViewModel

class BeerDetailsFragment : Fragment(R.layout.fragment_beer_details) {

    private val viewModel : BeerDetailsViewModel by activityViewModels()

    private var _binding : FragmentBeerDetailsBinding? = null
    private val binding get() = _binding!!

    val args : BeerDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentBeerDetailsBinding.bind(view)

        viewModel.beerDetailObserver().observe(viewLifecycleOwner) { beerDetail ->
            binding.apply {
                beerDescription.text = beerDetail.description
                if (beerDetail.ibu <= 20) {
                    beerBitterness.text = getString(R.string.smooth)
                } else if ((beerDetail.ibu <= 50) && (beerDetail.ibu > 20)) {
                    beerBitterness.text = getString(R.string.bitter)
                } else if (beerDetail.ibu < 50) {
                    beerBitterness.text = getString(R.string.hipster_plus)
                }

                val abv = beerDetail.abv.toString()
                alcoholPercentage.text = "$abv %"
            }
        }

        val beer = args.beer
        val id = beer.id
        viewModel.getBeerDetail(id)



    }

}