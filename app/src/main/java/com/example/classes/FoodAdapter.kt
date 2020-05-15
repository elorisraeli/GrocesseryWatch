package com.example.classes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.grocesserywatch.R
import kotlinx.android.synthetic.main.food_design.view.*

class FoodAdapter : BaseAdapter {
    var foodsList = ArrayList<Food>()
    var context: Context? = null

    constructor(context: Context, foodsList: ArrayList<Food>) : super() {
        this.context = context
        this.foodsList = foodsList
    }

    override fun getCount(): Int {
        return foodsList.size
    }

    override fun getItem(position: Int): Any {
        return foodsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.foodsList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.food_design, null)
        foodView.imgFood.setImageResource(food.image!!)
        foodView.tvName.text = food.name!!

        return foodView
    }
}