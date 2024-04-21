package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class WoodsInstructions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_woods_instructions)
    }

    fun startBtn (view : View){
        val intent = Intent(this, WoodsLevel::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)
    }

}