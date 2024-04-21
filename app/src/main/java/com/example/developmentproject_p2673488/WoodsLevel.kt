package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class WoodsLevel : AppCompatActivity() {

    private lateinit var flyTippingBtn: ImageButton
    private lateinit var bagBtn: ImageButton
    private lateinit var foodBtn: ImageButton
    private lateinit var petWasteBtn: ImageButton

    private lateinit var stickBtn: ImageButton
    private lateinit var mushroomBtn: ImageButton
    private lateinit var bugHotelBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_woods_level)

        var dbHelper = DatabaseHelper(this)

        flyTippingBtn = findViewById(R.id.flyTippingBtn)
        bagBtn = findViewById(R.id.bagBtn)
        foodBtn = findViewById(R.id.foodBtn)
        petWasteBtn = findViewById(R.id.petWasteBtn)

        flyTippingBtn.setOnClickListener{handleLitterClick("Fly Tipping")}
        bagBtn.setOnClickListener{handleLitterClick("Bag")}
        foodBtn.setOnClickListener{handleLitterClick("Food")}
        petWasteBtn.setOnClickListener{handleLitterClick("Pet Waste")}

        var flyTippingDB = dbHelper.getRubbish("Fly Tipping")
        var bagDB = dbHelper.getRubbish("Bag")
        var foodDB = dbHelper.getRubbish("Food")
        var petWasteDB = dbHelper.getRubbish("Pet Waste")

        if (flyTippingDB != null) {
            if(flyTippingDB.RubVisible.equals(0)){
                flyTippingBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Fly Tipping", 1)
            }
        }

        if (bagDB != null) {
            if(bagDB.RubVisible.equals(0)){
                bagBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Bag", 1)
            }
        }

        if (foodDB != null) {
            if(foodDB.RubVisible.equals(0)){
                foodBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Food", 1)
            }
        }

        if (petWasteDB != null) {
            if(petWasteDB.RubVisible.equals(0)){
                petWasteBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Pet Waste", 1)
            }
        }

        stickBtn = findViewById(R.id.stickBtn)
        mushroomBtn = findViewById(R.id.mushroomBtn)
        bugHotelBtn = findViewById(R.id.bugHotelBtn)

        stickBtn.setOnClickListener{handleNonLitterClick("Sticks")}
        mushroomBtn.setOnClickListener{handleNonLitterClick("Mushroom")}
        bugHotelBtn.setOnClickListener{handleNonLitterClick("Bug Hotel")}

        var stickDB = dbHelper.getNonRubbish("Sticks")
        var mushroomDB = dbHelper.getNonRubbish("Mushroom")
        var bugHotelDB = dbHelper.getNonRubbish("Bug Hotel")

        if (stickDB != null) {
            if(stickDB.NRubVisible.equals(0)){
                stickBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Sticks", 1)
            }
        }

        if (mushroomDB != null) {
            if(mushroomDB.NRubVisible.equals(0)){
                mushroomBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Mushroom", 1)
            }
        }

        if (bugHotelDB != null) {
            if(bugHotelDB.NRubVisible.equals(0)){
                bugHotelBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Bug Hotel", 1)
            }
        }

        if (dbHelper.allClicked("TRubbish", "RubClicked", "Woods") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Woods")){
            val intent = Intent(this, FinishedLevelWoods::class.java)
            startActivity(intent)
        }




    }

    private fun handleLitterClick(litterName: String){
        val dbHelper = DatabaseHelper(this)
        val litter = dbHelper.getRubbish(litterName)
        val intent = Intent(this, LitterPickUp::class.java)
        intent.putExtra("Litter", litter)
        startActivity(intent)
    }

    private fun handleNonLitterClick(nonLitterName: String){
        val dbHelper = DatabaseHelper(this)
        val nonLitter = dbHelper.getNonRubbish(nonLitterName)
        val intent = Intent(this, NonLitterPickup::class.java)
        intent.putExtra("NonLitter", nonLitter)
        startActivity(intent)
    }

    fun backBtn (view : View){
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)
    }
}