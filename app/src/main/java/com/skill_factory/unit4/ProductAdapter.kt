package com.skill_factory.unit4

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import java.util.ArrayList

class ProductAdapter() : ListDelegationAdapter<List<Item>>() {
    lateinit var data: ArrayList<Item>

    init {
        delegatesManager.addDelegate(ProductDelegateAdapter())
        delegatesManager.addDelegate(AdDelegateAdapter())
    }

    override fun setItems(items: List<Item>?) {
        super.setItems(items)
        notifyDataSetChanged()
    }

}