package com.example.unsplashapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unsplashapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, SearchFragment())
            .commit()
    }
}