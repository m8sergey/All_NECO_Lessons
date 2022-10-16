package com.example.all_neco_lessons.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityMainBottomNavigationViiewBinding

class MainActivityBottomNavigationViiew : AppCompatActivity() {
    private lateinit var binding: ActivityMainBottomNavigationViiewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBottomNavigationViiewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bNavigation.selectedItemId = R.id.item3
        binding.bNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this, "Item3", Toast.LENGTH_SHORT).show()
                R.id.item4 -> Toast.makeText(this, "Item4", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}