package com.devsahil.animatedtoolbar

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.Intents.Insert.ACTION
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.widget.Toolbar
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var avdImage : ImageView
    private var isChecked by Delegates.notNull<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myToolbar= findViewById<Toolbar>(R.id.myToolbar)
        setSupportActionBar(myToolbar)

        isChecked = false
        avdImage = findViewById(R.id.avdImage)
        avdImage.setOnClickListener{
            if(isChecked) {
                checkToClose()
            }
            else{
                closeToCheck()
            }
            isChecked = !isChecked
        }

    }

    private fun closeToCheck() {
        avdImage.setImageResource(R.drawable.avd_close_to_check)
        val avdCloseToCheck = avdImage.drawable as Animatable
        avdCloseToCheck.start()
    }

    private fun checkToClose() {
        avdImage.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose = avdImage.drawable as Animatable
        avdCheckToClose.start()
    }

    fun onClickButton(view: android.view.View) {
        if(isChecked) {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
        }
        else {
            Toast.makeText(this,"Please agree before proceeding",LENGTH_SHORT).show()
        }
    }
}