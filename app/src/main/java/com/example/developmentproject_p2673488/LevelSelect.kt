package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class LevelSelect : AppCompatActivity() {

    private lateinit var beachTrophy: ImageView
    private lateinit var woodsTrophy: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)

        var dbHelper = DatabaseHelper(this)

        beachTrophy = findViewById(R.id.beachTrophy)
        woodsTrophy = findViewById(R.id.woodsTrophy)


        if (dbHelper.allClicked("TRubbish", "RubClicked", "Beach") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Beach")){
            beachTrophy.visibility = View.VISIBLE
        }else{
            beachTrophy.visibility = View.INVISIBLE
        }

        if (dbHelper.allClicked("TRubbish", "RubClicked", "Woods") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Woods")){
            woodsTrophy.visibility = View.VISIBLE
        }else{
            woodsTrophy.visibility = View.INVISIBLE
        }

    }

    fun beachBtn (view : View){
        val intent = Intent(this, BeachInstructions::class.java)
        startActivity(intent)
    }

    fun woodsBtn (view : View){
        val intent = Intent(this, WoodsInstructions::class.java)
        startActivity(intent)
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}