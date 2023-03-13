package com.skill_factory.unit4

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class ItemTouchHelperCallback(val adapter: ProductAdapter) : ItemTouchHelper.Callback() {
    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val swipeFlags = ItemTouchHelper.END
        return makeMovementFlags(0, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val newList = arrayListOf<Item>()
        newList.addAll(adapter.items)
        newList.removeAt(viewHolder.adapterPosition)
        val diff = ProductDiff(adapter.items as ArrayList<Item>, newList)
        val diffResult = DiffUtil.calculateDiff(diff)
        adapter.items = newList
        diffResult.dispatchUpdatesTo(adapter)
    }

}