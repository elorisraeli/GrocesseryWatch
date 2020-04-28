package com.example.grocesserywatch

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    var isFavoriteBoolFirst = false

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addB: Button = findViewById(R.id.addButton)
        var myListB = findViewById<Button>(R.id.myListButton)
        var mtFavoriteB = findViewById<Button>(R.id.myFavoritesButton)


        mtFavoriteB.setOnClickListener {
            startActivity(Intent(this, MyFavorites::class.java))
        }

        myListB.setOnClickListener {
            startActivity(Intent(this, MyList::class.java))
        }

        var editTextProductName = findViewById<EditText>(R.id.editText_ProductName)
        var editTextDate = findViewById<EditText>(R.id.editText_Date)
        var editTextTime = findViewById<EditText>(R.id.editText_Time)

        val options1 = resources.getStringArray(R.array.Options_1)
        val options2 = resources.getStringArray(R.array.Options_2)
        val options3 = resources.getStringArray(R.array.Options_3)


        val spinner1 = findViewById<Spinner>(R.id.spinner)
        spinner1.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options1)
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, positionInArray: Int, p3: Long) {
                if (positionInArray != 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "Selected Item: " + options1[positionInArray], Toast.LENGTH_SHORT
                    ).show()
                    editTextProductName.setText(options1[positionInArray])
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Select Something", Toast.LENGTH_SHORT).show()
            }
        }


        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        spinner2.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options2)
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, positionInArray: Int, p3: Long) {
                if (positionInArray != 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "Selected Item: " + options2[positionInArray], Toast.LENGTH_SHORT
                    ).show()
                    editTextProductName.setText(options2[positionInArray])
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Select Something", Toast.LENGTH_SHORT).show()
            }
        }


        val spinner3 = findViewById<Spinner>(R.id.spinner3)
        spinner3.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options3)
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, positionInArray: Int, p3: Long) {
                if (positionInArray != 0) {
                    Toast.makeText(
                        this@MainActivity,
                        "Selected Item: " + options3[positionInArray], Toast.LENGTH_SHORT
                    ).show()
                    editTextProductName.setText(options3[positionInArray])
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Select Something", Toast.LENGTH_SHORT).show()
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

//   --------------Don't Work !!! I Don't Know What To Do.--------------

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
//
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
