package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class ParentZone : AppCompatActivity() {

    private lateinit var canCheck: CheckBox
    private lateinit var bottleCheck: CheckBox
    private lateinit var glassCheck: CheckBox
    private lateinit var ringsCheck: CheckBox
    private lateinit var bagCheck: CheckBox
    private lateinit var flyTippingCheck: CheckBox
    private lateinit var foodCheck: CheckBox
    private lateinit var petWasteCheck: CheckBox



    private lateinit var newspaperCheck: CheckBox
    private lateinit var seaweedCheck: CheckBox
    private lateinit var shellsCheck: CheckBox
    private lateinit var sandCastleCheck: CheckBox
    private lateinit var mushroomCheck: CheckBox
    private lateinit var bugHotelCheck: CheckBox
    private lateinit var sticksCheck: CheckBox

    private lateinit var errorTxt: TextView

    lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_zone)

        dbHelper = DatabaseHelper(this)

        canCheck = findViewById(R.id.canCheck)
        bottleCheck = findViewById(R.id.bottleCheck)
        glassCheck = findViewById(R.id.glassCheck)
        ringsCheck = findViewById(R.id.ringsCheck)
        bagCheck = findViewById(R.id.bagCheck)
        flyTippingCheck = findViewById(R.id.flyTippingCheck)
        foodCheck = findViewById(R.id.foodCheck)
        petWasteCheck = findViewById(R.id.petWasteCheck)


        newspaperCheck = findViewById(R.id.newspaperCheck)
        seaweedCheck = findViewById(R.id.seaweedCheck)
        shellsCheck = findViewById(R.id.shellsCheck)
        sandCastleCheck = findViewById(R.id.sandCastleCheck)
        mushroomCheck = findViewById(R.id.mushroomCheck)
        bugHotelCheck = findViewById(R.id.bugHotelCheck)
        sticksCheck = findViewById(R.id.sticksCheck)


        var canDB = dbHelper.getRubbish("Can")
        var bottleDB = dbHelper.getRubbish("Bottle")
        var glassDB = dbHelper.getRubbish("Glass")
        var ringsDB = dbHelper.getRubbish("Rings")
        var bagDB = dbHelper.getRubbish("Bag")
        var flyTippingDB = dbHelper.getRubbish("Fly Tipping")
        var foodDB = dbHelper.getRubbish("Food")
        var petWasteDB = dbHelper.getRubbish("Pet Waste")


        var newspaperDB = dbHelper.getNonRubbish("Newspaper")
        var seaWeedDB = dbHelper.getNonRubbish("Sea Weed")
        var shellsDB = dbHelper.getNonRubbish("Shells")
        var sandCastleDB = dbHelper.getNonRubbish("Sand Castle")
        var mushroomDB = dbHelper.getNonRubbish("Mushroom")
        var bugHotelDB = dbHelper.getNonRubbish("Bug Hotel")
        var sticksDB = dbHelper.getNonRubbish("Sticks")


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

        if (bagDB != null) {
            if(bagDB.RubParent.equals(1)){
                bagCheck.isChecked = true
            }
        }

        if (flyTippingDB != null) {
            if(flyTippingDB.RubParent.equals(1)){
                flyTippingCheck.isChecked = true
            }
        }

        if (foodDB != null) {
            if(foodDB.RubParent.equals(1)){
                foodCheck.isChecked = true
            }
        }

        if (petWasteDB != null) {
            if(petWasteDB.RubParent.equals(1)){
                petWasteCheck.isChecked = true
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

        if (mushroomDB != null) {
            if(mushroomDB.NRubParent.equals(1)){
                mushroomCheck.isChecked = true
            }
        }

        if (bugHotelDB != null) {
            if(bugHotelDB.NRubParent.equals(1)){
                bugHotelCheck.isChecked = true
            }
        }

        if (sticksDB != null) {
            if(sticksDB.NRubParent.equals(1)){
                sticksCheck.isChecked = true
            }
        }

    }

    fun confirmBtn(view: View) {

        val numChecked = listOf(canCheck, bottleCheck, glassCheck, ringsCheck, bagCheck, flyTippingCheck, foodCheck, petWasteCheck,
            newspaperCheck, seaweedCheck, shellsCheck, sandCastleCheck, mushroomCheck, bugHotelCheck, sticksCheck).count { it.isChecked }

        errorTxt = findViewById(R.id.errorTxtPZ)


        if (numChecked > 0){

            errorTxt.visibility = View.INVISIBLE

            updateRubbishDB("Can", if (canCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Can", if (canCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Can", if (canCheck.isChecked) 0 else 1)


            updateRubbishDB("Bottle", if (bottleCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Bottle", if (bottleCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Bottle", if (bottleCheck.isChecked) 0 else 1)


            updateRubbishDB("Glass", if (glassCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Glass", if (glassCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Glass", if (glassCheck.isChecked) 0 else 1)


            updateRubbishDB("Rings", if (ringsCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Rings", if (ringsCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Rings", if (ringsCheck.isChecked) 0 else 1)


            updateRubbishDB("Bag", if (bagCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Bag", if (bagCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Bag", if (bagCheck.isChecked) 0 else 1)


            updateRubbishDB("Fly Tipping", if (flyTippingCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Fly Tipping", if (flyTippingCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Fly Tipping", if (flyTippingCheck.isChecked) 0 else 1)


            updateRubbishDB("Food", if (foodCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Food", if (foodCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Food", if (foodCheck.isChecked) 0 else 1)


            updateRubbishDB("Pet Waste", if (petWasteCheck.isChecked) 1 else 0)
            updateRubbishDBParent("Pet Waste", if (petWasteCheck.isChecked) 1 else 0)
            dbHelper.updateRubbishClicked("Pet Waste", if (petWasteCheck.isChecked) 0 else 1)



            updateNRubbishDB("Newspaper", if (newspaperCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Newspaper", if (newspaperCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Newspaper", if (newspaperCheck.isChecked) 0 else 1)


            updateNRubbishDB("Sea Weed", if (seaweedCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Sea Weed", if (seaweedCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Sea Weed", if (seaweedCheck.isChecked) 0 else 1)


            updateNRubbishDB("Shells", if (shellsCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Shells", if (shellsCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Shells", if (shellsCheck.isChecked) 0 else 1)


            updateNRubbishDB("Sand Castle", if (sandCastleCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Sand Castle", if (sandCastleCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Sand Castle", if (sandCastleCheck.isChecked) 0 else 1)


            updateNRubbishDB("Mushroom", if (mushroomCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Mushroom", if (mushroomCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Mushroom", if (mushroomCheck.isChecked) 0 else 1)


            updateNRubbishDB("Bug Hotel", if (bugHotelCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Bug Hotel", if (bugHotelCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Bug Hotel", if (bugHotelCheck.isChecked) 0 else 1)


            updateNRubbishDB("Sticks", if (sticksCheck.isChecked) 1 else 0)
            updateNRubbishDBParent("Sticks", if (sticksCheck.isChecked) 1 else 0)
            dbHelper.updateNonRubbishClicked("Sticks", if (sticksCheck.isChecked) 0 else 1)



            dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", it.RubParent); dbHelper.updateRubbishClicked("Can", 0)}
            dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", it.RubParent); dbHelper.updateRubbishClicked("Bottle", 0) }
            dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", it.RubParent); dbHelper.updateRubbishClicked("Glass", 0) }
            dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", it.RubParent); dbHelper.updateRubbishClicked("Rings", 0) }
            dbHelper.getRubbish("Bag")?.let { dbHelper.updateRubbishVis("Bag", it.RubParent); dbHelper.updateRubbishClicked("Bag", 0) }
            dbHelper.getRubbish("Fly Tipping")?.let { dbHelper.updateRubbishVis("Fly Tipping", it.RubParent); dbHelper.updateRubbishClicked("Fly Tipping", 0) }
            dbHelper.getRubbish("Food")?.let { dbHelper.updateRubbishVis("Food", it.RubParent); dbHelper.updateRubbishClicked("Food", 0) }
            dbHelper.getRubbish("Pet Waste")?.let { dbHelper.updateRubbishVis("Pet Waste", it.RubParent); dbHelper.updateRubbishClicked("Pet Waste", 0) }



            dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateNonRubbishVis("Newspaper", it.NRubParent); dbHelper.updateNonRubbishClicked("Newspaper", 0) }
            dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateNonRubbishVis("Sea Weed", it.NRubParent); dbHelper.updateNonRubbishClicked("Sea Weed", 0) }
            dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateNonRubbishVis("Shells", it.NRubParent); dbHelper.updateNonRubbishClicked("Shells", 0) }
            dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateNonRubbishVis("Sand Castle", it.NRubParent); dbHelper.updateNonRubbishClicked("Sand Castle", 0) }
            dbHelper.getNonRubbish("Mushroom")?.let { dbHelper.updateNonRubbishVis("Mushroom", it.NRubParent); dbHelper.updateNonRubbishClicked("Mushroom", 0) }
            dbHelper.getNonRubbish("Bug Hotel")?.let { dbHelper.updateNonRubbishVis("Bug Hotel", it.NRubParent); dbHelper.updateNonRubbishClicked("Bug Hotel", 0) }
            dbHelper.getNonRubbish("Sticks")?.let { dbHelper.updateNonRubbishVis("Sticks", it.NRubParent); dbHelper.updateNonRubbishClicked("Sticks", 0) }
        }else{
            errorTxt.visibility = View.VISIBLE
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

    fun ratingBtn (view : View){
        val intent = Intent(this, Rating::class.java)
        startActivity(intent)
    }



    fun defaultBtn(view: View){


        errorTxt = findViewById(R.id.errorTxtPZ)

        errorTxt.visibility = View.INVISIBLE

        dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", 1); dbHelper.updateRubbishClicked("Can", 0); updateRubbishDBParent("Can", 1)}
        canCheck.isChecked = true
        dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", 1); dbHelper.updateRubbishClicked("Bottle", 0); updateRubbishDBParent("Bottle", 1) }
        bottleCheck.isChecked = true
        dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", 0); dbHelper.updateRubbishClicked("Glass", 1); updateRubbishDBParent("Glass", 0) }
        glassCheck.isChecked = false
        dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", 1); dbHelper.updateRubbishClicked("Rings", 0); updateRubbishDBParent("Rings", 1) }
        ringsCheck.isChecked = true
        dbHelper.getRubbish("Bag")?.let { dbHelper.updateRubbishVis("Bag", 1); dbHelper.updateRubbishClicked("Bag", 0); updateRubbishDBParent("Bag", 1) }
        bagCheck.isChecked = true
        dbHelper.getRubbish("Fly Tipping")?.let { dbHelper.updateRubbishVis("Fly Tipping", 0); dbHelper.updateRubbishClicked("Fly Tipping", 1); updateRubbishDBParent("Fly Tipping", 0) }
        flyTippingCheck.isChecked = false
        dbHelper.getRubbish("Food")?.let { dbHelper.updateRubbishVis("Food", 1); dbHelper.updateRubbishClicked("Food", 0); updateRubbishDBParent("Food", 1) }
        foodCheck.isChecked = true
        dbHelper.getRubbish("Pet Waste")?.let { dbHelper.updateRubbishVis("Pet Waste", 0); dbHelper.updateRubbishClicked("Pet Waste", 1); updateRubbishDBParent("Pet Waste", 0) }
        petWasteCheck.isChecked = false


        dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateNonRubbishVis("Newspaper", 1); dbHelper.updateNonRubbishClicked("Newspaper", 0); updateNRubbishDBParent("Newspaper", 1) }
        newspaperCheck.isChecked = true
        dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateNonRubbishVis("Sea Weed", 1); dbHelper.updateNonRubbishClicked("Sea Weed", 0); updateNRubbishDBParent("Sea Weed", 1) }
        seaweedCheck.isChecked = true
        dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateNonRubbishVis("Shells", 1); dbHelper.updateNonRubbishClicked("Shells", 0); updateNRubbishDBParent("Shells", 1) }
        shellsCheck.isChecked = true
        dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateNonRubbishVis("Sand Castle", 1); dbHelper.updateNonRubbishClicked("Sand Castle", 0); updateNRubbishDBParent("Sand Castle", 1) }
        sandCastleCheck.isChecked = true
        dbHelper.getNonRubbish("Mushroom")?.let { dbHelper.updateNonRubbishVis("Mushroom", 0); dbHelper.updateNonRubbishClicked("Mushroom", 1); updateNRubbishDBParent("Mushroom", 0) }
        mushroomCheck.isChecked = false
        dbHelper.getNonRubbish("Bug Hotel")?.let { dbHelper.updateNonRubbishVis("Bug Hotel", 1); dbHelper.updateNonRubbishClicked("Bug Hotel", 0); updateNRubbishDBParent("Bug Hotel", 1) }
        bugHotelCheck.isChecked = true
        dbHelper.getNonRubbish("Sticks")?.let { dbHelper.updateNonRubbishVis("Sticks", 1); dbHelper.updateNonRubbishClicked("Sticks", 0); updateNRubbishDBParent("Sticks", 1) }
        sticksCheck.isChecked = true

    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}