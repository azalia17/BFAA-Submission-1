package com.azalia.bfaa_submission_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.azalia.bfaa_submission_1.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    companion object{
        const val TIME_SPLASH= 1500L
    }

    private lateinit var splashBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        val handler = Handler(mainLooper)

        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_SPLASH)

        supportActionBar?.hide()
    }
}