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

    lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_zone)

        dbHelper = DatabaseHelper(this)

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

    }

    fun confirmBtn(view: View) {
        updateRubbishDB("Can", if (canCheck.isChecked) 1 else 0)
        updateRubbishDBParent("Can", if (canCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Can", if (canCheck.isChecked) 0 else 1)


        updateRubbishDB("Bottle", if (bottleCheck.isChecked) 1 else 0)
        updateRubbishDBParent("Bottle", if (bottleCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Bottle", if (canCheck.isChecked) 0 else 1)


        updateRubbishDB("Glass", if (glassCheck.isChecked) 1 else 0)
        updateRubbishDBParent("Glass", if (glassCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Glass", if (canCheck.isChecked) 0 else 1)


        updateRubbishDB("Rings", if (ringsCheck.isChecked) 1 else 0)
        updateRubbishDBParent("Rings", if (ringsCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Rings", if (canCheck.isChecked) 0 else 1)


        updateNRubbishDB("Newspaper", if (newspaperCheck.isChecked) 1 else 0)
        updateNRubbishDBParent("Newspaper", if (newspaperCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Newspaper", if (canCheck.isChecked) 0 else 1)


        updateNRubbishDB("Sea Weed", if (seaweedCheck.isChecked) 1 else 0)
        updateNRubbishDBParent("Sea Weed", if (seaweedCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Sea Weed", if (canCheck.isChecked) 0 else 1)


        updateNRubbishDB("Shells", if (shellsCheck.isChecked) 1 else 0)
        updateNRubbishDBParent("Shells", if (shellsCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Shells", if (canCheck.isChecked) 0 else 1)

        updateNRubbishDB("Sand Castle", if (sandCastleCheck.isChecked) 1 else 0)
        updateNRubbishDBParent("Sand Castle", if (sandCastleCheck.isChecked) 1 else 0)
        dbHelper.updateRubbishClicked("Sand Castle", if (canCheck.isChecked) 0 else 1)


        dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", it.RubParent); dbHelper.updateRubbishClicked("Can", 0)}
        dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", it.RubParent); dbHelper.updateRubbishClicked("Bottle", 0) }
        dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", it.RubParent); dbHelper.updateRubbishClicked("Glass", 0) }
        dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", it.RubParent); dbHelper.updateRubbishClicked("Rings", 0) }

        dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateRubbishVis("Newspaper", it.NRubParent); dbHelper.updateNonRubbishClicked("Newspaper", 0) }
        dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateRubbishVis("Sea Weed", it.NRubParent); dbHelper.updateNonRubbishClicked("Sea Weed", 0) }
        dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateRubbishVis("Shells", it.NRubParent); dbHelper.updateNonRubbishClicked("Shells", 0) }
        dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateRubbishVis("Sand Castle", it.NRubParent); dbHelper.updateNonRubbishClicked("Sand Castle", 0) }

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



    fun defaultBtn(view: View){
        dbHelper = DatabaseHelper(this)

        dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", 1); dbHelper.updateRubbishClicked("Can", 0); updateRubbishDBParent("Can", 1)}
        canCheck.isChecked = true
        dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", 1); dbHelper.updateRubbishClicked("Bottle", 0); updateRubbishDBParent("Bottle", 1) }
        bottleCheck.isChecked = true
        dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", 0); dbHelper.updateRubbishClicked("Glass", 0); updateRubbishDBParent("Glass", 0) }
        glassCheck.isChecked = false
        dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", 1); dbHelper.updateRubbishClicked("Rings", 0); updateRubbishDBParent("Rings", 1) }
        ringsCheck.isChecked = true

        dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateNonRubbishVis("Newspaper", 1); dbHelper.updateNonRubbishClicked("Newspaper", 0); updateNRubbishDBParent("Newspaper", 1) }
        newspaperCheck.isChecked = true
        dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateNonRubbishVis("Sea Weed", 1); dbHelper.updateNonRubbishClicked("Sea Weed", 0); updateNRubbishDBParent("Sea Weed", 1) }
        seaweedCheck.isChecked = true
        dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateNonRubbishVis("Shells", 1); dbHelper.updateNonRubbishClicked("Shells", 0); updateNRubbishDBParent("Shells", 1) }
        shellsCheck.isChecked = true
        dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateNonRubbishVis("Sand Castle", 1); dbHelper.updateNonRubbishClicked("Sand Castle", 0); updateNRubbishDBParent("Sand Castle", 1) }
        sandCastleCheck.isChecked = true

    }
}