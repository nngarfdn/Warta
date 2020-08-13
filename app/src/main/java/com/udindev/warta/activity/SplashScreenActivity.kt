package com.udindev.warta.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.udindev.warta.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

         Handler().postDelayed(Runnable {

            startActivity(Intent(this,MainActivity::class.java))

        },3000)
    }
}