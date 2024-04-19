package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.Litter
import kotlin.properties.Delegates

class LitterPickUp : AppCompatActivity() {

    lateinit var RubbishPick : String
    var RubbishVis by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_litter_pick_up)

        var selectedRubbish = (intent.getSerializableExtra("Litter") as Litter)

        var RubbishName = selectedRubbish.RubName
        var RubbishDesc = selectedRubbish.RubDescription
        RubbishPick = selectedRubbish.RubPickup
        RubbishVis = selectedRubbish.RubVisible

        var itemNameTxt = findViewById<TextView>(R.id.itemNameTxt)
        var itemDescTxt = findViewById<TextView>(R.id.itemDescTxt)

        itemNameTxt.setText(RubbishName)
        itemDescTxt.setText(RubbishDesc)


    }

    fun GlovesBtn (view : View){
        if (RubbishPick.equals("Gloves")){
            RubbishVis == 0
            val intent = android.content.Intent(
                this,
                com.example.developmentproject_p2673488.BeachLevel::class.java)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
        }

    }


    fun PickerBtn (view : View){
        if (RubbishPick.equals("Picker")){
            RubbishVis == 0
            val intent = android.content.Intent(
                this,
                com.example.developmentproject_p2673488.BeachLevel::class.java)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
        }

    }


    fun adultBtn (view : View){
        if (RubbishPick.equals("Adult")){
            RubbishVis == 0
            val intent = android.content.Intent(
                this,
                com.example.developmentproject_p2673488.BeachLevel::class.java)
            startActivity(intent)

        }else{
            var pickError = findViewById<TextView>(R.id.pickErrorTxt)
            pickError.visibility = View.VISIBLE
        }

    }
}