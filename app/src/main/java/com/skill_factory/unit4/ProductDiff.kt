package com.skill_factory.unit4

import androidx.recyclerview.widget.DiffUtil

class ProductDiff(val oldList: ArrayList<Item>, val newList: ArrayList<Item>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]
        return old.idIcon == new.idIcon &&
                old.desc == new.desc &&
                old.name == new.name
    }
}