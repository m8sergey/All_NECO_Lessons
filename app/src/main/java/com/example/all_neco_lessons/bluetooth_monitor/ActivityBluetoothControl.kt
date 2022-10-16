package com.example.all_neco_lessons.bluetooth_monitor

import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.ActivityBluetoothContorlBinding

class ActivityBluetoothControl : AppCompatActivity(), ReceiveThread.Listener {
    private lateinit var binding: ActivityBluetoothContorlBinding
    private lateinit var actListLauncher: ActivityResultLauncher<Intent>
    private lateinit var bluetoothConnect: BluetoothConnection
    private var listItem: ListItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBluetoothContorlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBluetoothListResult()
        init()
// Само собой еще нужен микроконтроллер который принимает bluetooth сигнал и отправляет ответ
//https://www.youtube.com/watch?v=Y8sdsxXMl8g&list=PLmjT2NFTgg1fdtg_gGbNMU0bKkgxfV_1t&index=5&ab_channel=NecoRu
// 17:15
        binding.apply {
            bA.setOnClickListener {
                bluetoothConnect.sendMessage("A")
            }
            bB.setOnClickListener {
                bluetoothConnect.sendMessage("B")
            }
        }
    }

    private fun init() {
        val btManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val btAdapter = btManager.adapter
        bluetoothConnect = BluetoothConnection(btAdapter, this, this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bloetooth_monitor_control_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.list) {
            actListLauncher.launch(Intent(this, BluetoothList::class.java))
        } else if (item.itemId == R.id.connect_bluetooth) {
            listItem.let {
                bluetoothConnect.connect(it?.mac!!)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onBluetoothListResult() {
        actListLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                listItem = it.data?.getSerializableExtra(BluetoothList.DEVICE_KEY) as ListItem
            }
        }
    }

    override fun onReceive(message: String) {
        runOnUiThread {
            binding.txtMessage.text = message
        }
    }
}