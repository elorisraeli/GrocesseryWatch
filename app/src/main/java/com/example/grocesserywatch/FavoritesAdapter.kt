package com.example.grocesserywatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.alert_view.view.*
import java.util.*

class FavoritesAdapter(val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FavoritesAdapter.ViewHolder, position: Int) {
        val item: Item = itemList[position]
        holder.textProductsName.text = item.productName
        holder.textDate.text = item.date
        holder.textTime.text = item.timeZone


        val context = holder.itemView.context
        val alertView =
            LayoutInflater.from(context).inflate(R.layout.alert_view,null)
        holder.buttonSet.setOnClickListener {
            val builder = androidx.appcompat.app.AlertDialog.Builder(context)
            builder.setTitle("Set Your Item")
            builder.setView(alertView)
            builder.setMessage("You able to change name, date and time.")
            val alert = builder.show()
            alertView.buttonSetInAlert.setOnClickListener {
                alert.dismiss()
                val productsName = alertView.editText_ProductNameAlert.text.toString()
                val date = alertView.editText_DateAlert.text.toString()
                val time = alertView.editText_TimeAlert.text.toString()

                holder.textProductsName.text = productsName
                holder.textDate.text = date
                holder.textTime.text = time
            }
            alertView.buttonCencelInAlert.setOnClickListener {
                alert.dismiss()
            }

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textProductsName = view.findViewById<TextView>(R.id.textProductName)
        val textDate = view.findViewById<TextView>(R.id.textDate)
        val textTime = view.findViewById<TextView>(R.id.textTime)
        val buttonSet = view.findViewById<Button>(R.id.buttonSet)
    }
}
