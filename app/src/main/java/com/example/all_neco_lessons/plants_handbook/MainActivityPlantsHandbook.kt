package com.example.all_neco_lessons.plants_handbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.all_neco_lessons.databinding.ActivityMainPlantsHandbookBinding

class MainActivityPlantsHandbook : AppCompatActivity() {
    private lateinit var binding: ActivityMainPlantsHandbookBinding
    private val adapter = PlantAdapter()
    private lateinit var editLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPlantsHandbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("key1") as Plant)
            }
        }
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivityPlantsHandbook, 3)
            rcView.adapter = adapter
            btnAbdd.setOnClickListener {
                editLauncher.launch(
                    Intent(
                        this@MainActivityPlantsHandbook,
                        ActivityEditPlantsHandbook::class.java
                    )
                )
            }
        }
    }
}