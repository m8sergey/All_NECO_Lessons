package com.example.all_neco_lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import com.example.all_neco_lessons.QR.MainActivityQA
import com.example.all_neco_lessons.accelero_test.MainActivityAcceleroTest
import com.example.all_neco_lessons.android_permissions.MainActivityAndroidPermissions
import com.example.all_neco_lessons.bluetooth_monitor.ActivityBluetoothControl
import com.example.all_neco_lessons.bottomnavigationview.MainActivityBottomNavigationViiew
import com.example.all_neco_lessons.count_down_timer.ActivityCountDownTimer
import com.example.all_neco_lessons.cristal_ball.MainActivityCristalBall
import com.example.all_neco_lessons.databinding.ActivityBluetoothMonitorListBinding
import com.example.all_neco_lessons.databinding.ActivityMainBinding
import com.example.all_neco_lessons.drawer_layout.MainActivityDrawerLayout
import com.example.all_neco_lessons.fragments.MainActivityFragments
import com.example.all_neco_lessons.plants_handbook.MainActivityPlantsHandbook
import com.example.all_neco_lessons.pythagorean_theorem.MainActivityPythagoreanTheorem
import com.example.all_neco_lessons.tool_bar.ActivityToolBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items = arrayOf(
            "Pythagorean Theorem",
            "Drawer Layout",
            "BottomNavigationView",
            "Cristal Ball",
            "Count down Timer",
            "Tool Bar",
            "Plants Handbook",
            "Fragments",
            "AcceleroTest",
            "Android Permissions",
            "QR",
            "BluetoothMonitor"
        )
        val adapterListView = ArrayAdapter(this, R.layout.main_item, items)
        val listView: ListView = binding.mainListView
        listView.adapter = adapterListView

        listView.setOnItemClickListener { _, _, position, _ ->
            when(position) {
                0 -> startActivity(Intent(this@MainActivity, MainActivityPythagoreanTheorem::class.java))
                1 -> startActivity(Intent(this@MainActivity, MainActivityDrawerLayout::class.java))
                2 -> startActivity(Intent(this@MainActivity, MainActivityBottomNavigationViiew::class.java))
                3 -> startActivity(Intent(this@MainActivity, MainActivityCristalBall::class.java))
                4 -> startActivity(Intent(this@MainActivity, ActivityCountDownTimer::class.java))
                5 -> startActivity(Intent(this@MainActivity, ActivityToolBar::class.java))
                6 -> startActivity(Intent(this@MainActivity, MainActivityPlantsHandbook::class.java))
                7 -> startActivity(Intent(this@MainActivity, MainActivityFragments::class.java))
                8 -> startActivity(Intent(this@MainActivity, MainActivityAcceleroTest::class.java))
                9 -> startActivity(Intent(this@MainActivity, MainActivityAndroidPermissions::class.java))
                10 -> startActivity(Intent(this@MainActivity, MainActivityQA::class.java))
                11 -> startActivity(Intent(this@MainActivity, ActivityBluetoothControl::class.java))
            }
        }
    }
}