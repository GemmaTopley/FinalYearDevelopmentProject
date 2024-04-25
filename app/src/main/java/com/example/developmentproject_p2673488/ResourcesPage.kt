package com.example.developmentproject_p2673488

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ResourcesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resources_page)
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun litterCritterBtn (view : View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.abcya.com/games/recycling_game"))
        startActivity(intent)
    }

    fun bugHotelsBtn (view : View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.famly.co/blog/bug-hotels-early-years"))
        startActivity(intent)
    }

    fun songBtn (view : View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chosic.com/download-audio/58134/#google_vignette"))
        startActivity(intent)
    }

}