package com.skill_factory.unit4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ProductAdapter(
            arrayListOf(
                Product(
                    0,
                    R.drawable.ic_apple,
                    "Apple",
                    "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
                ),
                Product(
                    1,
                    R.drawable.ic_banana,
                    "Banana",
                    "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
                ),
                Product(
                    2,
                    R.drawable.ic_lemon,
                    "Lemon",
                    "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
                ),
                Product(
                    3,
                    R.drawable.ic_pear,
                    "Pear",
                    "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
                ),
                Product(
                    4,
                    R.drawable.ic_strawberry,
                    "Strawberry",
                    "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
                ),
                Product(
                    5,
                    R.drawable.ic_orange,
                    "Orange",
                    "Orange juice is widely used as a drink in restaurants and cafes."
                )
            )
        )
        recyclerView.adapter = adapter
        val itemIndex = findViewById<EditText>(R.id.item_index)
        val add = findViewById<Button>(R.id.add)
        val change = findViewById<Button>(R.id.change)
        val remove = findViewById<Button>(R.id.remove)

        fun getIndex(): Int {
            return itemIndex.text.toString().toInt()
        }

        fun updateData(newList: ArrayList<Product>) {
            val oldList = adapter.data
            val productDiff = ProductDiff(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(productDiff)
            adapter.data = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        add.setOnClickListener() {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList.add(
                getIndex(),
                Product(adapter.data.size, R.drawable.ic_apple, "Apple", "Description")
            )
            updateData(newList)

//            adapter.data.add(
//                getIndex(),
//                Product(adapter.data.size, R.drawable.ic_apple, "Apple", "Description")
//            )
//            adapter.notifyItemInserted(getIndex())
        }

        change.setOnClickListener() {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList[getIndex()] =
                Product(adapter.data.size, R.drawable.ic_orange, "Orange", "Description")
            updateData(newList)

//            adapter.data[getIndex()] =
//                Product(adapter.data.size, R.drawable.ic_orange, "Orange", "Description")
//            adapter.notifyItemChanged(getIndex())
        }

        remove.setOnClickListener() {
            val newList = arrayListOf<Product>()
            newList.addAll(adapter.data)
            newList.removeAt(getIndex())
            updateData(newList)

//            adapter.data.removeAt(getIndex())
//            adapter.notifyItemRemoved(getIndex())
        }
    }
}
