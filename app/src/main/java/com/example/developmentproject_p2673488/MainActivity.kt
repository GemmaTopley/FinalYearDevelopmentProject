package com.example.developmentproject_p2673488

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.developmentproject_p2673488.Model.DatabaseHelper

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper
    var mp = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mp.setDataSource(this,
            Uri.parse("android.resource://"+this.packageName+"/"+R.raw.sakuragirlbeachchosic))
        mp.prepare()
        mp.start()
        /*
         Beach by Sakura Girl | https://soundcloud.com/sakuragirl_official
         Music promoted by https://www.chosic.com/free-music/all/
         Creative Commons CC BY 3.0
         https://creativecommons.org/licenses/by/3.0/
        */

    }

    fun playBtn (view : View){
        val intent = Intent(this, LevelSelect::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp= MediaPlayer()

    }

    fun parentBtn(view: View){
        val intent = Intent(this, ParentZoneValidation::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp=MediaPlayer()
    }

    fun resetBtn(view: View){
        dbHelper = DatabaseHelper(this)

        dbHelper.getRubbish("Can")?.let { dbHelper.updateRubbishVis("Can", it.RubParent); dbHelper.updateRubbishClicked("Can", 0)}
        dbHelper.getRubbish("Bottle")?.let { dbHelper.updateRubbishVis("Bottle", it.RubParent); dbHelper.updateRubbishClicked("Bottle", 0) }
        dbHelper.getRubbish("Glass")?.let { dbHelper.updateRubbishVis("Glass", it.RubParent); dbHelper.updateRubbishClicked("Glass", 0) }
        dbHelper.getRubbish("Rings")?.let { dbHelper.updateRubbishVis("Rings", it.RubParent); dbHelper.updateRubbishClicked("Rings", 0) }
        dbHelper.getRubbish("Fly Tipping")?.let { dbHelper.updateRubbishVis("Fly Tipping", it.RubParent); dbHelper.updateRubbishClicked("Fly Tipping", 0) }
        dbHelper.getRubbish("Bag")?.let { dbHelper.updateRubbishVis("Bag", it.RubParent); dbHelper.updateRubbishClicked("Bag", 0) }
        dbHelper.getRubbish("Food")?.let { dbHelper.updateRubbishVis("Food", it.RubParent); dbHelper.updateRubbishClicked("Food", 0) }
        dbHelper.getRubbish("Pet Waste")?.let { dbHelper.updateRubbishVis("Pet Waste", it.RubParent); dbHelper.updateRubbishClicked("Pet Waste", 0) }


        dbHelper.getNonRubbish("Newspaper")?.let { dbHelper.updateRubbishVis("Newspaper", it.NRubParent); dbHelper.updateNonRubbishClicked("Newspaper", 0) }
        dbHelper.getNonRubbish("Sea Weed")?.let { dbHelper.updateRubbishVis("Sea Weed", it.NRubParent); dbHelper.updateNonRubbishClicked("Sea Weed", 0) }
        dbHelper.getNonRubbish("Shells")?.let { dbHelper.updateRubbishVis("Shells", it.NRubParent); dbHelper.updateNonRubbishClicked("Shells", 0) }
        dbHelper.getNonRubbish("Sand Castle")?.let { dbHelper.updateRubbishVis("Sand Castle", it.NRubParent); dbHelper.updateNonRubbishClicked("Sand Castle", 0) }
        dbHelper.getNonRubbish("Mushroom")?.let { dbHelper.updateRubbishVis("Mushroom", it.NRubParent); dbHelper.updateNonRubbishClicked("Mushroom", 0) }
        dbHelper.getNonRubbish("Bug Hotel")?.let { dbHelper.updateRubbishVis("Bug Hotel", it.NRubParent); dbHelper.updateNonRubbishClicked("Bug Hotel", 0) }
        dbHelper.getNonRubbish("Sticks")?.let { dbHelper.updateRubbishVis("Sticks", it.NRubParent); dbHelper.updateNonRubbishClicked("Sticks", 0) }


    }

    fun resourcesBtn(view: View){
        val intent = Intent(this, ResourcesPage::class.java)
        startActivity(intent)

        mp.stop()
        mp.release()
        mp=MediaPlayer()
    }



    override fun onBackPressed() {
        //do nothing
    }
}