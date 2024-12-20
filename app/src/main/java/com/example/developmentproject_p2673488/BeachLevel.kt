package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class BeachLevel : AppCompatActivity() {

    private lateinit var canBtn: ImageButton
    private lateinit var bottleBtn: ImageButton
    private lateinit var glassBtn: ImageButton
    private lateinit var ringsBtn: ImageButton

    private lateinit var newsBtn: ImageButton
    private lateinit var seaWeedBtn: ImageButton
    private lateinit var shellsButton: ImageButton
    private lateinit var sandCastleBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_level)

        var dbHelper = DatabaseHelper(this)

        canBtn = findViewById(R.id.canBtn)
        bottleBtn = findViewById(R.id.bottleBtn)
        glassBtn = findViewById(R.id.glassBtn)
        ringsBtn = findViewById(R.id.ringsBtn)

        canBtn.setOnClickListener{handleLitterClick("Can")}
        bottleBtn.setOnClickListener{handleLitterClick("Bottle")}
        glassBtn.setOnClickListener{handleLitterClick("Glass")}
        ringsBtn.setOnClickListener{handleLitterClick("Rings")}

        var canDB = dbHelper.getRubbish("Can")
        var bottleDB = dbHelper.getRubbish("Bottle")
        var glassDB = dbHelper.getRubbish("Glass")
        var ringsDB = dbHelper.getRubbish("Rings")

        if (canDB != null) {
            if(canDB.RubVisible.equals(0)){
                canBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Can", 1)
            }
        }

        if (bottleDB != null) {
            if(bottleDB.RubVisible.equals(0)){
                bottleBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Bottle", 1)

            }
        }

        if (glassDB != null) {
            if(glassDB.RubVisible.equals(0)){
                glassBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Glass", 1)

            }
        }

        if (ringsDB != null) {
            if(ringsDB.RubVisible.equals(0)){
                ringsBtn.visibility = View.INVISIBLE
                dbHelper.updateRubbishClicked("Rings", 1)

            }
        }


        newsBtn = findViewById(R.id.newsBtn)
        seaWeedBtn = findViewById(R.id.seaWeedBtn)
        shellsButton = findViewById(R.id.shellsBtn)
        sandCastleBtn = findViewById(R.id.sandCastleBtn)

        newsBtn.setOnClickListener{handleNonLitterClick("Newspaper")}
        seaWeedBtn.setOnClickListener{handleNonLitterClick("Sea Weed")}
        shellsButton.setOnClickListener{handleNonLitterClick("Shells")}
        sandCastleBtn.setOnClickListener{handleNonLitterClick("Sand Castle")}

        var newsDB = dbHelper.getNonRubbish("Newspaper")
        var seaWeedDB = dbHelper.getNonRubbish("Sea Weed")
        var shellsDB = dbHelper.getNonRubbish("Shells")
        var sandCastleDB = dbHelper.getNonRubbish("Sand Castle")

        if (newsDB != null) {
            if(newsDB.NRubVisible.equals(0)){
                newsBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Newspaper", 1)
            }
        }

        if (seaWeedDB != null) {
            if(seaWeedDB.NRubVisible.equals(0)){
                seaWeedBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Sea Weed", 1)
            }
        }

        if (shellsDB != null) {
            if(shellsDB.NRubVisible.equals(0)){
                shellsButton.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Shells", 1)
            }
        }

        if (sandCastleDB != null) {
            if(sandCastleDB.NRubVisible.equals(0)){
                sandCastleBtn.visibility = View.INVISIBLE
                dbHelper.updateNonRubbishClicked("Sand Castle", 1)
            }
        }


        if (dbHelper.allClicked("TRubbish", "RubClicked", "Beach") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Beach")){
            val intent = Intent(this, FinishedLevelBeach::class.java)
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

    override fun onBackPressed() {
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)
    }
}