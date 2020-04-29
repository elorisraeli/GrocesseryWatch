package com.example.grocesserywatch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val editTextDate = findViewById<EditText>(R.id.editText_Date)
        val editTextTime = findViewById<EditText>(R.id.editText_Time)

        val arrayStrings = arrayOf(
            resources.getStringArray(R.array.Options_1),
            resources.getStringArray(R.array.Options_2),
            resources.getStringArray(R.array.Options_3)
        )
        val arraySpinners = arrayOf(spinner1, spinner2, spinner3)

        for ((index, spinner) in arraySpinners.withIndex()) {
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayStrings[index])
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, positionInArray: Int, p3: Long) {
                    if (positionInArray != 0) {
                        Toast.makeText(
                            this@MainActivity,
                            "Selected Item: " + (arrayStrings[index])[positionInArray].toString(), Toast.LENGTH_SHORT
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
            if (editTextDate.length() != 0 || editTextTime.length() != 0)
                Toast.makeText(
                    this@MainActivity,
                    "Item Added: " + editTextProductName.text, Toast.LENGTH_SHORT
                ).show()
            else
                Toast.makeText(
                    this@MainActivity,
                    "YOU MUST ENTER DATE AND TIME !", Toast.LENGTH_SHORT
                ).show()

        }


//           ------------------ JUST A LOT OF CODE WHICH I SHORT TO FEW LINES -------------
//        val options1 = resources.getStringArray(R.array.Options_1)
//        val spinner1 = findViewById<Spinner>(R.id.spinner1)
//        spinner1.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options1)
//        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, positionInArray: Int, p3: Long) {
//                if (positionInArray != 0) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Selected Item: " + options1[positionInArray], Toast.LENGTH_SHORT
//                    ).show()
//                    editTextProductName.setText(options1[positionInArray])
//                }
//            }


//   --------------Don't Work !!! I Don't Know What To Do.--------------
//    var isFavoriteBoolFirst = false
//        var favoriteButton = findViewById<Button>(R.id.favoriteB)
//        favoriteButton.setOnClickListener {
//            if (isFavoriteBoolFirst) {
//                favoriteButton.setBackgroundResource(android.R.drawable.star_big_on)
//                isFavoriteBoolFirst = false
//            } else
//                favoriteButton.setBackgroundResource(android.R.drawable.star_big_off)
//            isFavoriteBoolFirst = true
//
//        }

//        var imageView: ImageView? = findViewById(R.drawable.favoritestaroff)
//        if (imageView != null) {
//            imageView.setOnClickListener {
//                isFavorite(isFavoriteBoolFirst)
//            }
//        }
    }

//   --------------Don't Work !!! I Don't Know What To Do.--------------
//    private fun isFavorite(isFavoriteBool: Boolean) {
//        if (!isFavoriteBool) {
//            imageView.setBackgroundResource(R.drawable.favoritestaroff)
//            isFavoriteBoolFirst = false
//        } else {
//            imageView.setBackgroundResource(R.drawable.favoritestaron)
//            isFavoriteBoolFirst = true
//            Toast.makeText(
//                this@MainActivity,
//                "The item added to favorites :)", Toast.LENGTH_SHORT
//            ).show()
//        }
//    }

}
