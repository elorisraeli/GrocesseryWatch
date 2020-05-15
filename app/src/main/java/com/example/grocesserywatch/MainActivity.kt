package com.example.grocesserywatch

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.classes.Food
import com.example.classes.FoodAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    var adapter: FoodAdapter? = null
    var foodsList = ArrayList<Food>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        foodsList.add(Food("Pancake", R.drawable.pancake))
        foodsList.add(Food("hamburger", R.drawable.hamburger))
        foodsList.add(Food("pizza", R.drawable.pizza))
        foodsList.add(Food("tost", R.drawable.tost))
        foodsList.add(Food("lazania", R.drawable.lazania))
        foodsList.add(Food("chicken", R.drawable.chicken))

        adapter = FoodAdapter(this, foodsList)
        gridViewFood.adapter = adapter

        val addB: Button = findViewById(R.id.addButton)
        val myListB = findViewById<Button>(R.id.myListButton)
        val mtFavoriteB = findViewById<Button>(R.id.myFavoritesButton)


        mtFavoriteB.setOnClickListener {
            startActivity(Intent(this, MyFavorites::class.java))
        }

        myListB.setOnClickListener {
            startActivity(Intent(this, MyList::class.java))
        }

        val editTextProductName = findViewById<EditText>(R.id.editText_ProductName)
        val buttonChooseTime = findViewById<Button>(R.id.buttonChooseTime)
        val buttonChooseDate = findViewById<Button>(R.id.buttonChooseDate)

        val arrayStrings = arrayOf(
            resources.getStringArray(R.array.Options_1),
            resources.getStringArray(R.array.Options_2),
            resources.getStringArray(R.array.Options_3)
        )
        val arraySpinners = arrayOf(spinner1, spinner2, spinner3)

        for ((index, spinner) in arraySpinners.withIndex()) {
            spinner.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayStrings[index])
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    positionInArray: Int,
                    p3: Long
                ) {
                    if (positionInArray != 0) {
                        Toast.makeText(
                            this@MainActivity,
                            "Selected Item: " + (arrayStrings[index])[positionInArray].toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        editTextProductName.setText((arrayStrings[index])[positionInArray].toString())
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    Toast.makeText(this@MainActivity, "Select Something", Toast.LENGTH_SHORT).show()
                }
            }
        }

        addB.setOnClickListener {
            Toast.makeText(
                this@MainActivity, "" + buttonChooseTime.text + buttonChooseDate.text
                , Toast.LENGTH_SHORT
            ).show()
        }

        val now = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH:mm", Locale.US)
        val dateFormat = SimpleDateFormat("dd.MM.YYYY", Locale.US)
        buttonChooseDate.setOnClickListener {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                buttonChooseDate.text = dateFormat.format(selectedDate.time)
//                val date = dateFormat.parse(buttonChooseDate.text.toString())
//                now.time = date
                Toast.makeText(this@MainActivity, "" + now.time, Toast.LENGTH_LONG).show()

            },
            now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        buttonChooseTime.setOnClickListener {
            val timePicker = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { timePicker, hoursOfDay, minutes ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, hoursOfDay)
                    selectedTime.set(Calendar.MINUTE, minutes)
                    buttonChooseTime.text = timeFormat.format(selectedTime.time)
                    val time = timeFormat.parse(buttonChooseTime.text.toString())
                    now.time = time
                },
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true
            )
            timePicker.show()
        }
    }
}
