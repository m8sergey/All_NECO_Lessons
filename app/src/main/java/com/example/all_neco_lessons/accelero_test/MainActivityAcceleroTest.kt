package com.example.all_neco_lessons.accelero_test

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.all_neco_lessons.databinding.ActivityMainAcceleroTestBinding

class MainActivityAcceleroTest : AppCompatActivity() {
    private lateinit var binding: ActivityMainAcceleroTestBinding
    private lateinit var sManager: SensorManager
    private var magnetic = FloatArray(9)
    private var gravity = FloatArray(9)

    private var accrs = FloatArray(3)
    private var magf = FloatArray(3)
    private var values = FloatArray(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAcceleroTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor1 = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val sensor2 = sManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        val sListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                when (event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> accrs = event.values.clone()
                    Sensor.TYPE_MAGNETIC_FIELD -> magf = event.values.clone()
                }

                SensorManager.getRotationMatrix(gravity, magnetic, accrs, magf)
                val outGravity = FloatArray(9)
                SensorManager.remapCoordinateSystem(
                    gravity,
                    SensorManager.AXIS_X,
                    SensorManager.AXIS_Z,
                    outGravity
                )

                SensorManager.getOrientation(outGravity, values)
                val degree = values[2] * 57.2958f
                val rotate = 270 + degree
                binding.lRotation.rotation = rotate
                val rData = 90 + degree
                val color = if (rData.toInt() == 0) Color.GREEN else Color.RED
                binding.lRotation.setBackgroundColor(color)
                binding.txtSensor.text = rData.toInt().toString()
            }

            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
        }

        sManager.registerListener(sListener, sensor1, SensorManager.SENSOR_DELAY_NORMAL)
        sManager.registerListener(sListener, sensor2, SensorManager.SENSOR_DELAY_NORMAL)
    }
}