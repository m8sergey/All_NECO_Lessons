package com.example.all_neco_lessons.plants_handbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityEditPlantsHandbookBinding
import com.example.all_neco_lessons.databinding.ActivityMainPlantsHandbookBinding
import com.example.all_neco_lessons.databinding.PlantItemBinding

class ActivityEditPlantsHandbook : AppCompatActivity() {
    private lateinit var binding: ActivityEditPlantsHandbookBinding
    private var indexImage = 0
    private var imageId = R.drawable.p_1_vasilek
    private var imageIdList = listOf(
        R.drawable.p_1_vasilek,
        R.drawable.p_2_klever,
        R.drawable.p_3_chicory,
        R.drawable.p_4_camomile,
        R.drawable.p_5_campanula
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPlantsHandbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()

    }

    private fun initButtons() = with(binding) {
        btnNext.setOnClickListener {
            imageId = imageIdList[indexImage]
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageView2.setImageResource(imageId)
        }
        btntDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("key1", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}
