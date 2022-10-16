package com.example.all_neco_lessons.pythagorean_theorem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.all_neco_lessons.databinding.ActivityPythagoreanTheorem2Binding

class ActivityPythagoreanTheorem2 : AppCompatActivity() {
    private lateinit var binding: ActivityPythagoreanTheorem2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPythagoreanTheorem2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickActPyTh2(view: View) {
        val i = Intent()
        i.putExtra("key1", "data")
        setResult(RESULT_OK, i)
        finish()
    }
}