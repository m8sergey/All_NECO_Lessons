package com.example.all_neco_lessons.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityMainFragmentsBinding

class MainActivityFragments : AppCompatActivity() {
    private lateinit var binding: ActivityMainFragmentsBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFragment(R.id.place_holder1, BlankFragment1.newInstance())
        openFragment(R.id.place_holder2, BlankFragment2.newInstance())

        dataModel.messageForA.observe(this) {
            binding.textView.text = it
        }
    }

    private fun openFragment(holder: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(holder, f)
            .commit()
    }

}