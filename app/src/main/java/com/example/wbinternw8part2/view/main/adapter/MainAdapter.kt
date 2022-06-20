package com.example.wbinternw8part2.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wbinternw8part2.R
import com.example.wbinternw8part2.model.data.DataModel
import com.squareup.picasso.Picasso

class MainAdapter(
    private val onListItemClickListener: OnHeroListItemClickListener
) : RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    private var data: ArrayList<DataModel> = arrayListOf()

    fun setData(newData: List<DataModel>) {
        val diffUtilsCallBack = DiffUtilsCallBack(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallBack)
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recycler_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class RecyclerItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: DataModel) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.findViewById<TextView>(R.id.name).text = data.name

                Picasso.with(itemView.context)
                    .load(data.images.md)
                    .error(R.drawable.ic_baseline_no_photography_24)
                    .into(itemView.findViewById<ImageView>(R.id.image))

                itemView.setOnClickListener { openInNewWindow(data) }
            }
        }

        private fun openInNewWindow(dataModel: DataModel) {
            onListItemClickListener.onItemClick(dataModel)
        }
    }

    interface OnHeroListItemClickListener {
        fun onItemClick(dataModel: DataModel)
    }
}