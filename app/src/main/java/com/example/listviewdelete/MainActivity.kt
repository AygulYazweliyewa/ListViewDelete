package com.example.listviewdelete

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf(
        Item("Apple", R.drawable.apple),
        Item("Banana", R.drawable.banana),
        Item("Cherry", R.drawable.cherry),
        Item("Grape", R.drawable.grape),
        Item("Orange", R.drawable.orange),
        Item("Strawberry", R.drawable.strawberry)
    )
    private val adapter = MyAdapter(items)


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_delete, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete -> {
                adapter.deleteItems()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

