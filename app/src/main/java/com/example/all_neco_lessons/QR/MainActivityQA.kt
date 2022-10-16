package com.example.all_neco_lessons.QR

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.all_neco_lessons.databinding.ActivityMainQaBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivityQA : AppCompatActivity() {
    private lateinit var binding: ActivityMainQaBinding
    private var im: ImageView? = null
    private var bGenerate: Button? = null
    private var bScanner: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainQaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        im = binding.imageView
        bGenerate = binding.button
        bScanner = binding.btnScanner

        bGenerate?.setOnClickListener {
            generateQrCode("Русский текст. English. 日本語. 123456789")
        }

        bScanner?.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun generateQrCode(text: String) {
        val barcodeEncoder = BarcodeEncoder()
        try {
            val bMap = barcodeEncoder.encodeBitmap(
                text,
                BarcodeFormat.QR_CODE,
                600,
                600
            )
            im?.setImageBitmap(bMap)
        } catch (e: WriterException) {
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                12
            )
        } else {
            startActivity(Intent(this, ActivityScannerQA::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 12) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(this, ActivityScannerQA::class.java))
            }
        }
    }
}