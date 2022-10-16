package com.example.all_neco_lessons.tool_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityToolBarBinding

class ActivityToolBar : AppCompatActivity() {
    private lateinit var binding: ActivityToolBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Admin"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu_tool_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.sync -> Toast.makeText(this, "Sync", Toast.LENGTH_SHORT).show()
            R.id.save -> Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            R.id.search -> Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}