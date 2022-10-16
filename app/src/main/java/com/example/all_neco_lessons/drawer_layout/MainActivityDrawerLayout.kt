package com.example.all_neco_lessons.drawer_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityMainDrawerLayoutBinding

class MainActivityDrawerLayout : AppCompatActivity() {
    private lateinit var binding: ActivityMainDrawerLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnOpen.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
            navV.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> Toast.makeText(
                        this@MainActivityDrawerLayout,
                        "Item1",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.item2 -> Toast.makeText(
                        this@MainActivityDrawerLayout,
                        "Item2",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }
}