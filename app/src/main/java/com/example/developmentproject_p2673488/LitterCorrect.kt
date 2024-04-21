package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.DatabaseHelper
import com.example.developmentproject_p2673488.Model.Litter

class LitterCorrect : AppCompatActivity() {

    lateinit var RubbishDisposal: String
    lateinit var RubbishDisposalInfo: String
    lateinit var RubbishName: String

    lateinit var selectedRubbish: Litter

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_litter_correct)

        dbHelper = DatabaseHelper(this)

        selectedRubbish = (intent.getSerializableExtra("Litter") as Litter)

        RubbishName = selectedRubbish.RubName
        RubbishDisposal = selectedRubbish.RubDisposal
        RubbishDisposalInfo = selectedRubbish.RubDisposalInfo

        var itemNameTxt = findViewById<TextView>(R.id.itemNameTxt)
        var itemDescTxt = findViewById<TextView>(R.id.itemDescTxt)

        itemNameTxt.setText(RubbishDisposal)
        itemDescTxt.setText(RubbishDisposalInfo)


    }

    fun okBtn (view : View){
        dbHelper.updateRubbishVis(RubbishName, 0)
        dbHelper.updateRubbishClicked(RubbishName, 1)
        if(dbHelper.getRubbish(RubbishName)?.Level == "Beach"){
            val intent = Intent(this, BeachLevel::class.java)
            startActivity(intent)
        }else if(dbHelper.getRubbish(RubbishName)?.Level == "Woods"){
            val intent = Intent(this, WoodsLevel::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        //do nothing
    }
}