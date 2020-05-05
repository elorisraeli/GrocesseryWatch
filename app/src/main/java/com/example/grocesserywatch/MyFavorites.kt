package com.example.grocesserywatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyFavorites : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_favorites)
         val recyclerView = findViewById<RecyclerView>(R.id.favorite_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemArray = ArrayList<Item>()
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Watermelon", "05/05/2020", "14:30"))
        itemArray.add(Item("eggs bucks", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))
        itemArray.add(Item("Milk", "05/05/2020", "14:30"))

        val itemDecoration =
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        val adapter = FavoritesAdapter(itemArray)
        recyclerView.adapter = adapter
    }
}
