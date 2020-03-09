package andrey.dudukov.breweries.core.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M, VH : BaseAdapter.BaseViewHolder<M>> :
    RecyclerView.Adapter<VH>() {

    var itemClickListener: ((M, View) -> Unit)? = null

    val items: MutableList<M> = mutableListOf()

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position], position)
        holder.itemView.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION && holder.adapterPosition < itemCount) {
                itemClickListener?.invoke(items[position], it)
            }
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

    abstract class BaseViewHolder<M>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: M, position: Int)
    }
}