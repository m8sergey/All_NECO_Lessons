package com.example.all_neco_lessons.count_down_timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.all_neco_lessons.databinding.ActivityCountDownTimerBinding

class ActivityCountDownTimer : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownTimerBinding
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startCountDownTimer(20_000)
        }
    }

    private fun startCountDownTimer(timeMilliseconds: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMilliseconds, 100) {
            override fun onTick(millisecond: Long) {
                binding.txtTimer.text = millisecond.toString()
            }
            override fun onFinish() {
                binding.txtTimer.text = "Finished"
            }
        }.start()
    }
}