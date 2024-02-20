package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LevelSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)
    }

    fun beachBtn (view : View){
        val intent = Intent(this, BeachLevel::class.java)
        startActivity(intent)
    }

    fun forestBtn (view : View){
        //val intent = Intent(this, forestLevel::class.java)
        startActivity(intent)
    }
}