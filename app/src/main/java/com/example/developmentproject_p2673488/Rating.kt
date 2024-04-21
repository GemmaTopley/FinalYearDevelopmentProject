package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class Rating : AppCompatActivity() {

    val dbHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        val noStarsTxt: TextView =findViewById(R.id.noStarsTxt)
        val averageStars = String.format("%.1f", dbHelper.getAverageRating())
        val addBtn = findViewById<Button>(R.id.addBtn)
        val starBar = findViewById<RatingBar>(R.id.newRatingBar)


        noStarsTxt.setText(averageStars + " Stars")

        starBar.visibility = View.VISIBLE
        addBtn.visibility = View.VISIBLE

    }

    fun addBtn (view : View){
        val starBar = findViewById<RatingBar>(R.id.newRatingBar)
        val newStars = starBar.rating
        val addBtn = findViewById<Button>(R.id.addBtn)

        val errorText = findViewById<TextView>(R.id.errorTxtRate)

        if (newStars == 0.0f){
            errorText.text = "Please enter number of stars"
            errorText.visibility = View.VISIBLE

        }else{
            errorText.text = "Rating added - Thank you"
            errorText.visibility = View.VISIBLE

            starBar.visibility = View.INVISIBLE
            addBtn.visibility = View.INVISIBLE


            dbHelper.addRating(newStars.toInt())
        }

    }

    fun backBtn (view : View){
        val intent = Intent(this, ParentZone::class.java)
        startActivity(intent)
    }
}