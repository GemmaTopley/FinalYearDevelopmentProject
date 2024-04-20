package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class LevelSelect : AppCompatActivity() {

    private lateinit var beachTrophy: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)

        var dbHelper = DatabaseHelper(this)

        beachTrophy = findViewById(R.id.beachTrophy)


        if (dbHelper.allClicked("TRubbish", "RubClicked") && dbHelper.allClicked("TNonRubbish", "NRubClicked")){
            beachTrophy.visibility = View.VISIBLE
        }else{
            beachTrophy.visibility = View.INVISIBLE
        }

    }

    fun beachBtn (view : View){
        val intent = Intent(this, BeachInstructions::class.java)
        startActivity(intent)
    }

    fun forestBtn (view : View){
        val intent = Intent(this, WoodsLevel::class.java)
        startActivity(intent)
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}