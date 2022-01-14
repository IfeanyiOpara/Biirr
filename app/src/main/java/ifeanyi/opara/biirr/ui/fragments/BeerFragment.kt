package ifeanyi.opara.biirr.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ifeanyi.opara.biirr.R
import ifeanyi.opara.biirr.adapter.BeerAdapter
import ifeanyi.opara.biirr.databinding.FragmentBeerBinding
import ifeanyi.opara.biirr.ui.viewModel.BeerViewModel

class BeerFragment : Fragment(R.layout.fragment_beer) {

    private val viewModel : BeerViewModel by activityViewModels()

    private var _binding : FragmentBeerBinding? = null
    private val binding get() =_binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentBeerBinding.bind(view)

        val adapter = BeerAdapter()

        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("beer", it)
            }

            findNavController().navigate(
                R.id.action_beerFragment_to_beerDetailsFragment,
                bundle
            )
        }

        viewModel.getBeerObserver().observe(viewLifecycleOwner, Observer {
            adapter.differ.submitList(it.toList())
        })

        binding.apply {
            rvBeer.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                setAdapter(adapter)
            }
        }
    }

}