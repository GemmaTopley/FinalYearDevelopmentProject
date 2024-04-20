package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun playBtn (view : View){
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)
    }

    fun parentBtn(view: View){
        val intent = Intent(this, ParentZoneValidation::class.java)
        startActivity(intent)
    }

    fun resetBtn(view: View){
        dbHelper = DatabaseHelper(this)

        dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", it.RubParent); dbHelper.updateRubbishClicked("Can", 0)}
        dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", it.RubParent); dbHelper.updateRubbishClicked("Bottle", 0) }
        dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", it.RubParent); dbHelper.updateRubbishClicked("Glass", 0) }
        dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", it.RubParent); dbHelper.updateRubbishClicked("Rings", 0) }

        dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateRubbishVis("Newspaper", it.NRubParent); dbHelper.updateNonRubbishClicked("Newspaper", 0) }
        dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateRubbishVis("Sea Weed", it.NRubParent); dbHelper.updateNonRubbishClicked("Sea Weed", 0) }
        dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateRubbishVis("Shells", it.NRubParent); dbHelper.updateNonRubbishClicked("Shells", 0) }
        dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateRubbishVis("Sand Castle", it.NRubParent); dbHelper.updateNonRubbishClicked("Sand Castle", 0) }


    }
}