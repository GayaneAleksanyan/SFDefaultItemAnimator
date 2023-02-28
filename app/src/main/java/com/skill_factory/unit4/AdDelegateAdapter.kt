package com.skill_factory.unit4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class AdDelegateAdapter :
    AbsListItemAdapterDelegate<Ad, Item, AdDelegateAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle = itemView.findViewById<TextView>(R.id.title)
        val textContent = itemView.findViewById<TextView>(R.id.content)
    }

    override fun isForViewType(item: Item, items: MutableList<Item>, position: Int): Boolean {
        return item is Ad
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
        )
    }

    override fun onBindViewHolder(item: Ad, holder: ViewHolder, payloads: MutableList<Any>) {
        holder.textTitle.text = item.title
        holder.textContent.text = item.content
    }
}