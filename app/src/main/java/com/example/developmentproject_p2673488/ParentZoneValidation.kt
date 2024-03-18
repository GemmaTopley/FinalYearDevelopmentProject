package com.example.developmentproject_p2673488

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class ParentZoneValidation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_zone_validation)
    }

    fun submitBtn (view : View){
        val answer = findViewById<TextView>(R.id.answerTxt)
        val error = findViewById<TextView>(R.id.errorTxt)
        if(answer.text.toString() == "27"){
            val intent = Intent(this, ParentZone::class.java)
            startActivity(intent)
        } else {
            error.visibility = View.VISIBLE
        }
    }

    fun homeBtn (view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}