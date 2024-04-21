package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FinishedLevelWoods : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished_level_woods)
    }

    fun homeBtn (view : View){
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)
    }
}