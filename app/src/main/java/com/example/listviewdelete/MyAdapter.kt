package com.example.listviewdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val items: MutableList<Item>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Define a view holder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    // Create a list of items to delete
    private val deleteList = mutableListOf<Item>()

    // Override the onCreateViewHolder method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        // Return a view holder
        return ViewHolder(view)
    }

    // Override the onBindViewHolder method
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the item at the position
        val item = items[position]
        // Bind the item data to the views
        holder.nameTextView.text = item.name
        holder.imageView.setImageResource(item.image)
        // Set a check change listener for the checkbox
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            // Add or remove the item from the delete list
            if (isChecked) {
                deleteList.add(item)
            } else {
                deleteList.remove(item)
            }
        }
    }

    // Override the getItemCount method
    override fun getItemCount(): Int {
        // Return the size of the display list
        return items.size
    }

    // Define a method that deletes the items from the delete list
    fun deleteItems() {
        // Loop through the delete list
        for (item in deleteList) {
            // Get the index of the item in the display list
            val index = items.indexOf(item)
            // Remove the item from the display list
            items.removeAt(index)
            // Notify the adapter of the removal
            notifyItemRemoved(index)
        }
        // Clear the delete list
        deleteList.clear()
    }
}