package com.example.lesson_8.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_8.R
import com.example.lesson_8.databinding.MainActivityBinding
import com.example.lesson_8.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainActivityBinding.inflate(layoutInflater).root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}