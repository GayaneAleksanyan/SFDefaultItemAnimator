package com.skill_factory.unit4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ProductAdapter()
        adapter.items = arrayListOf(
            Product(
                0,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Ad("Sale", "30% discount on Apples", "Sale", "desc", R.drawable.ic_apple, 0),
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
            Ad("Ad", "Ad from partner", "Ad", "desc", R.drawable.ic_launcher_background, 1),
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
            ),
            Product(
                6,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            ),
            Product(
                7,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Product(
                8,
                R.drawable.ic_orange,
                "Orange",
                "Orange juice is widely used as a drink in restaurants and cafes."
            ),
            Product(
                9,
                R.drawable.ic_strawberry,
                "Strawberry",
                "A perennial herbaceous plant 5-20 cm high, with a thick brown rhizome. \"Mustache\" is short. The stem is thin."
            ),
            Product(
                10,
                R.drawable.ic_lemon,
                "Lemon",
                "Lemons are eaten fresh, and are also used in the manufacture of confectionery and soft drinks, in the liquor and perfume industry."
            ),
            Ad("Ad", "Ad from partner", "Ad", "desc", R.drawable.ic_launcher_background, 2),
            Product(
                11,
                R.drawable.ic_pear,
                "Pear",
                "Under favorable conditions, the pear reaches a large size-up to 5-25 meters in height and 5 meters in diameter of the crown."
            ),
            Product(
                12,
                R.drawable.ic_apple,
                "Apple",
                "Juicy Apple fruit, which is eaten fresh, serves as a raw material in cooking and for making drinks."
            ),
            Ad("Sale", "30% discount on Apples", "Sale", "desc", R.drawable.ic_apple, 3),
            Product(
                13,
                R.drawable.ic_banana,
                "Banana",
                "It is one of the oldest food crops, and for tropical countries it is the most important food plant and the main export item."
            )
        )
        recyclerView.adapter = adapter

        var savePositionFirst = 0
        var savePositionLast = 0

        fun savePosition() {
            savePositionFirst =
                (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
            savePositionLast =
                (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
        }

        fun scrollToStart() {
            recyclerView.scrollToPosition(0)
        }

        fun scrollToSaveStartPosition() {
            recyclerView.scrollToPosition(savePositionFirst)
        }

        fun scrollToSaveLastPosition() {
            recyclerView.scrollToPosition(savePositionLast)
        }

        fun scrollToEnd() {
            recyclerView.scrollToPosition(adapter.itemCount - 1)
        }

        val up = findViewById<ImageView>(R.id.up)
        val save = findViewById<ImageView>(R.id.save)
        val down = findViewById<ImageView>(R.id.down)

        up.setOnClickListener {
            if ((recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition() == 0) {
                scrollToSaveLastPosition()
            } else {
                scrollToStart()
            }
        }

        save.setOnClickListener {
            savePosition()
        }

        down.setOnClickListener {
            if ((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == adapter.itemCount - 1) {
                scrollToSaveStartPosition()
            } else {
                scrollToEnd()
            }
        }


        val itemIndex = findViewById<EditText>(R.id.item_index)
        val add = findViewById<Button>(R.id.add)
        val change = findViewById<Button>(R.id.change)
        val remove = findViewById<Button>(R.id.remove)

        fun getIndex(): Int {
            return itemIndex.text.toString().toInt()
        }

        fun updateData(newList: ArrayList<Item>) {
            val oldList = adapter.data
            val productDiff = ProductDiff(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(productDiff)
            adapter.data = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        add.setOnClickListener() {
            val newList = arrayListOf<Item>()
            newList.addAll(adapter.data)
            newList.add(
                getIndex(), Product(adapter.data.size, R.drawable.ic_apple, "Apple", "Description")
            )
            updateData(newList)
        }

        change.setOnClickListener() {
            val newList = arrayListOf<Item>()
            newList.addAll(adapter.data)
            newList[getIndex()] =
                Product(adapter.data.size, R.drawable.ic_orange, "Orange", "Description")
            updateData(newList)
        }

        remove.setOnClickListener() {
            val newList = arrayListOf<Item>()
            newList.addAll(adapter.data)
            newList.removeAt(getIndex())
            updateData(newList)
        }
    }
}
