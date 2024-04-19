package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class BeachLevel : AppCompatActivity() {

    private lateinit var canBtn: ImageButton
    private lateinit var bottleBtn: ImageButton
    private lateinit var glassBtn: ImageButton
    private lateinit var ringsBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_level)

        canBtn = findViewById(R.id.canBtn)
        bottleBtn = findViewById(R.id.bottleBtn)
        glassBtn = findViewById(R.id.glassBtn)
        ringsBtn = findViewById(R.id.ringsBtn)

        canBtn.setOnClickListener{handleLitterClick("Can")}
        bottleBtn.setOnClickListener{handleLitterClick("Bottle")}
        glassBtn.setOnClickListener{handleLitterClick("Glass")}
        ringsBtn.setOnClickListener{handleLitterClick("Rings")}


    }

    private fun handleLitterClick(litterName: String){
        val dbHelper = DatabaseHelper(this)
        val litter = dbHelper.getRubbish(litterName)

        val intent = Intent(this, LitterPickUp::class.java)
        intent.putExtra("Litter", litter)
        startActivity(intent)
    }

    fun backBtn (view : View){
        val intent = Intent(this, BeachInstructions::class.java)
        startActivity(intent)
    }
}