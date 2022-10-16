package com.example.all_neco_lessons.pythagorean_theorem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityPythagoreanTheoremBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivityPythagoreanTheorem : AppCompatActivity() {
    private lateinit var binding: ActivityPythagoreanTheoremBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPythagoreanTheoremBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                val someText = it.data?.getStringExtra("key1")
                Log.d("MyLog", "Data from ActivityPythagoreanTheorem2")
            }
        }
    }

    fun onClickLauncher(view: View) {
        launcher.launch(Intent(this, ActivityPythagoreanTheorem2::class.java))
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
            binding.txtResult.text = result
        }
    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Empty field"
            if (edB.text.isNullOrEmpty()) edB.error = "Empty field"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        binding.apply {
            val a = edA.text.toString().toFloat().pow(2)
            val b = edB.text.toString().toFloat().pow(2)
            return sqrt((a + b)).toString()
        }
    }
}