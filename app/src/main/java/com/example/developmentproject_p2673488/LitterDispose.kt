package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.DatabaseHelper
import com.example.developmentproject_p2673488.Model.Litter

class LitterDispose : AppCompatActivity() {

    lateinit var RubbishName: String
    lateinit var RubbishDispose: String
    lateinit var RubbishDesc: String

    lateinit var selectedRubbish: Litter

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_litter_dispose)

        dbHelper = DatabaseHelper(this)

        selectedRubbish = (intent.getSerializableExtra("Litter") as Litter)

        RubbishName = selectedRubbish.RubName
        RubbishDesc = selectedRubbish.RubDescription
        RubbishDispose = selectedRubbish.RubDisposal

        var itemNameTxt = findViewById<TextView>(R.id.itemNameTxt)
        var itemDescTxt = findViewById<TextView>(R.id.itemDescTxt)

        itemNameTxt.setText(RubbishName)
        itemDescTxt.setText(RubbishDesc)

    }

    fun RecycleBtn(view: View){
        if (RubbishDispose.equals("Recycle")){
            val litter = dbHelper.getRubbish(selectedRubbish.RubName)
            val intent = Intent(this,LitterCorrect::class.java)
            intent.putExtra("Litter", litter)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
            dbHelper.updateRubbishClicked(RubbishName, 1)
        }
    }

    fun GeneralBtn(view: View){
        if (RubbishDispose.equals("General Waste")){
            val litter = dbHelper.getRubbish(selectedRubbish.RubName)
            val intent = Intent(this,LitterCorrect::class.java)
            intent.putExtra("Litter", litter)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
            dbHelper.updateRubbishClicked(RubbishName, 1)
        }
    }

    fun CompostBtn(view: View){
        if (RubbishDispose.equals("Compost")){
            val litter = dbHelper.getRubbish(selectedRubbish.RubName)
            val intent = Intent(this,LitterCorrect::class.java)
            intent.putExtra("Litter", litter)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
            dbHelper.updateRubbishClicked(RubbishName, 1)
        }
    }
}