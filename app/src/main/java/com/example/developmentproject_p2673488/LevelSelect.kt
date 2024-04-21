package com.example.developmentproject_p2673488

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class LevelSelect : AppCompatActivity() {

    private lateinit var beachTrophy: ImageView
    private lateinit var woodsTrophy: ImageView

    var mp = MediaPlayer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select)

        var dbHelper = DatabaseHelper(this)

        beachTrophy = findViewById(R.id.beachTrophy)
        woodsTrophy = findViewById(R.id.woodsTrophy)


        if (dbHelper.allClicked("TRubbish", "RubClicked", "Beach") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Beach")){
            beachTrophy.visibility = View.VISIBLE
        }else{
            beachTrophy.visibility = View.INVISIBLE
        }

        if (dbHelper.allClicked("TRubbish", "RubClicked", "Woods") && dbHelper.allClicked("TNonRubbish", "NRubClicked", "Woods")){
            woodsTrophy.visibility = View.VISIBLE
        }else{
            woodsTrophy.visibility = View.INVISIBLE
        }

        mp.setDataSource(this, Uri.parse("android.resource://"+this.packageName+"/"+R.raw.sakuragirlbeachchosic))
        mp.prepare()
        mp.start()
        /*
         Beach by Sakura Girl | https://soundcloud.com/sakuragirl_official
         Music promoted by https://www.chosic.com/free-music/all/
         Creative Commons CC BY 3.0
         https://creativecommons.org/licenses/by/3.0/
        */

    }

    fun beachBtn (view : View){
        val intent = Intent(this, BeachInstructions::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp=MediaPlayer()
    }

    fun woodsBtn (view : View){
        val intent = Intent(this, WoodsInstructions::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp=MediaPlayer()
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp=MediaPlayer()
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}