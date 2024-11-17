package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.DatabaseHelper
import com.example.developmentproject_p2673488.Model.NonLitter

class NonLitterPickup : AppCompatActivity() {

    lateinit var NRubbishName: String
    lateinit var NRubbishDesc: String

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_litter_pickup)

        dbHelper = DatabaseHelper(this)

        var selectedRubbish = (intent.getSerializableExtra("NonLitter") as NonLitter)

        NRubbishName = selectedRubbish.NRubName
        NRubbishDesc = selectedRubbish.NRubDescription

        var itemNameTxt = findViewById<TextView>(R.id.itemNameTxt)
        var itemDescTxt = findViewById<TextView>(R.id.itemDescTxt)

        itemNameTxt.setText(NRubbishName)
        itemDescTxt.setText(NRubbishDesc)
    }


    fun okBtn (view : View){
        if(dbHelper.getNonRubbish(NRubbishName)?.Level == "Beach"){
            dbHelper.updateNonRubbishClicked(NRubbishName, 1)
            val intent = Intent(this, BeachLevel::class.java)
            startActivity(intent)
        }else if(dbHelper.getNonRubbish(NRubbishName)?.Level == "Woods"){
            dbHelper.updateNonRubbishClicked(NRubbishName, 1)
            val intent = Intent(this, WoodsLevel::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        //do nothing
    }

}