package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class ParentZone : AppCompatActivity() {

    private lateinit var canCheck: CheckBox
    private lateinit var bottleCheck: CheckBox
    private lateinit var glassCheck: CheckBox
    private lateinit var ringsCheck: CheckBox
    private lateinit var newspaperCheck: CheckBox
    private lateinit var seaweedCheck: CheckBox
    private lateinit var shellsCheck: CheckBox
    private lateinit var sandCastleCheck: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_zone)

        var dbHelper = DatabaseHelper(this)

        canCheck = findViewById(R.id.canCheck)
        bottleCheck = findViewById(R.id.bottleCheck)
        glassCheck = findViewById(R.id.glassCheck)
        ringsCheck = findViewById(R.id.ringsCheck)
        newspaperCheck = findViewById(R.id.newspaperCheck)
        seaweedCheck = findViewById(R.id.seaweedCheck)
        shellsCheck = findViewById(R.id.shellsCheck)
        sandCastleCheck = findViewById(R.id.sandCastleCheck)

        var canDB = dbHelper.getRubbish("Can")
        var bottleDB = dbHelper.getRubbish("Bottle")
        var glassDB = dbHelper.getRubbish("Glass")
        var ringsDB = dbHelper.getRubbish("Rings")
        var newspaperDB = dbHelper.getNonRubbish("Newspaper")
        var seaWeedDB = dbHelper.getNonRubbish("Sea Weed")
        var shellsDB = dbHelper.getNonRubbish("Shells")
        var sandCastleDB = dbHelper.getNonRubbish("Sand Castle")

        if (canDB != null) {
            if(canDB.RubParent.equals(1)){
                canCheck.isChecked = true
            }
        }

        if (bottleDB != null) {
            if(bottleDB.RubParent.equals(1)){
                bottleCheck.isChecked = true
            }
        }

        if (glassDB != null) {
            if(glassDB.RubParent.equals(1)){
                glassCheck.isChecked = true
            }
        }

        if (ringsDB != null) {
            if(ringsDB.RubParent.equals(1)){
                ringsCheck.isChecked = true
            }
        }

        if (newspaperDB != null) {
            if(newspaperDB.NRubParent.equals(1)){
                newspaperCheck.isChecked = true
            }
        }

        if (seaWeedDB != null) {
            if(seaWeedDB.NRubParent.equals(1)){
                seaweedCheck.isChecked = true
            }
        }

        if (shellsDB != null) {
            if(shellsDB.NRubParent.equals(1)){
                shellsCheck.isChecked = true
            }
        }

        if (sandCastleDB != null) {
            if(sandCastleDB.NRubParent.equals(1)){
                sandCastleCheck.isChecked = true
            }
        }


        canCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateRubbishDB("Can", if (isChecked) 1 else 0)
            updateRubbishDBParent("Can", if (isChecked) 1 else 0)
        }

        bottleCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateRubbishDB("Bottle", if (isChecked) 1 else 0)
            updateRubbishDBParent("Bottle", if (isChecked) 1 else 0)
        }

        glassCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateRubbishDB("Glass", if (isChecked) 1 else 0)
            updateRubbishDBParent("Glass", if (isChecked) 1 else 0)
        }

        ringsCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateRubbishDB("Rings", if (isChecked) 1 else 0)
            updateRubbishDBParent("Rings", if (isChecked) 1 else 0)
        }

        newspaperCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateNRubbishDB("Newspaper", if (isChecked) 1 else 0)
            updateNRubbishDBParent("Newspaper", if (isChecked) 1 else 0)
        }

        seaweedCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateNRubbishDB("Sea Weed", if (isChecked) 1 else 0)
            updateNRubbishDBParent("Sea Weed", if (isChecked) 1 else 0)
        }

        shellsCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateNRubbishDB("Shells", if (isChecked) 1 else 0)
            updateNRubbishDBParent("Shells", if (isChecked) 1 else 0)
        }
        sandCastleCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            updateNRubbishDB("Sand Castle", if (isChecked) 1 else 0)
            updateNRubbishDBParent("Sand Castle", if (isChecked) 1 else 0)
        }



    }

    private fun updateRubbishDB(item:String, checked: Int){
        var dbHelper = DatabaseHelper(this)
        dbHelper.updateRubbishVis(item, checked)
    }

    private fun updateNRubbishDB(item:String, checked: Int){
        var dbHelper = DatabaseHelper(this)
        dbHelper.updateNonRubbishVis(item, checked)
    }

    private fun updateRubbishDBParent(item:String, checked: Int){
        var dbHelper = DatabaseHelper(this)
        dbHelper.updateRubbishVisParent(item, checked)
    }

    private fun updateNRubbishDBParent(item:String, checked: Int){
        var dbHelper = DatabaseHelper(this)
        dbHelper.updateNonRubbishVisParent(item, checked)
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}