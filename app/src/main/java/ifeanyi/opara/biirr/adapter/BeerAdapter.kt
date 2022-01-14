package ifeanyi.opara.biirr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ifeanyi.opara.biirr.databinding.ItemBeerReviewBinding
import ifeanyi.opara.biirr.models.Beer
import kotlinx.android.synthetic.main.item_beer_review.view.*

class BeerAdapter : RecyclerView.Adapter<BeerAdapter.ViewHolder>() {

    inner class ViewHolder(val itemView: ItemBeerReviewBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBeerReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current  = differ.currentList[position]

        holder.itemView.item_beer_name.text = current.name
        holder.itemView.item_beer_tagLine.text = current.tagLine
        Glide.with(holder.itemView.item_beer_image).load(current.image_url).into(holder.itemView.item_beer_image)

        holder.itemView.setOnClickListener {
                onItemClickListener?.let { it(current) }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }



    //DiffUtil calculates the differences between two lists and enable us to update the items that are different,
    //instead of having to update the entire recyclerview even the ones that didn't change. And it does it in the background
    private val diffCallback = object : DiffUtil.ItemCallback<Beer>(){
        override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
            return oldItem == newItem
        }
    }

    //the list differ is the tool that would take our two lists and compare them and check the difference and
    //only update the items that would change, while running in the background
    val differ = AsyncListDiffer(this, diffCallback) // we submit our list to this differ object

    private var onItemClickListener: ((Beer) -> Unit)? = null

    fun setOnItemClickListener(listener: (Beer) -> Unit){
        onItemClickListener = listener
    }
}