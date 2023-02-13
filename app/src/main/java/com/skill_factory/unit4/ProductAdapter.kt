package com.skill_factory.unit4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

const val ITEM_VIEW_TYPE_PRODUCT = 0
const val ITEM_VIEW_TYPE_AD = 1

class ProductAdapter(var data: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_VIEW_TYPE_PRODUCT) {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            )
        } else if (viewType == ITEM_VIEW_TYPE_AD) {
            return AdViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_ad, parent, false)
            )
        } else {
            throw IllegalArgumentException("Invalid Item Type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position] is Product) {
            ITEM_VIEW_TYPE_PRODUCT
        } else if (data[position] is Ad) {
            ITEM_VIEW_TYPE_AD
        } else {
            throw IllegalArgumentException("Invalid Item Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM_VIEW_TYPE_PRODUCT) {
            val h = holder as ViewHolder
            val item = data[position] as Product
            h.icon.setImageResource(item.idIcon as Int)
            h.textName.text = item.name
            h.textDesc.text = item.desc
        } else if (getItemViewType(position) == ITEM_VIEW_TYPE_AD) {
            val h = holder as AdViewHolder
            val item = data[position] as Ad
            h.textTitle.text = item.title
            h.textContent.text = item.content
        }
    }

    override fun getItemId(position: Int): Long {
        return data[position].hashCode().toLong()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.findViewById<ImageView>(R.id.icon)
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        val textDesc = itemView.findViewById<TextView>(R.id.text_desc)
    }

    class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle = itemView.findViewById<TextView>(R.id.title)
        val textContent = itemView.findViewById<TextView>(R.id.content)
    }

}