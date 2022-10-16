package com.example.all_neco_lessons.cristal_ball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityMainCristalBallBinding

class MainActivityCristalBall : AppCompatActivity() {
    private lateinit var binding: ActivityMainCristalBallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCristalBallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txt.setOnClickListener {
            binding.txt.text = getReto()
        }
    }
    private fun getReto(): String {
        return resources.getStringArray(R.array.retos)[randomNumber()]
    }
    private fun randomNumber(): Int {
        val size = resources.getStringArray(R.array.retos).size
        return (0 until size).random()
    }
}