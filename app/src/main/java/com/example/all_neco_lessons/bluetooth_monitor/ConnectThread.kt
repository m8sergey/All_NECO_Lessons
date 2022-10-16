package com.example.all_neco_lessons.bluetooth_monitor

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import java.io.IOException
import java.util.*

class ConnectThread(
    device: BluetoothDevice,
    private val context: Context,
    private val listener: ReceiveThread.Listener
) : Thread() {
    private val uuid = "00001101-0000-1000-8000-00805F9B34FB"
    private var mSocket: BluetoothSocket? = null
    lateinit var rThread: ReceiveThread

    init {
        try {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityResultContracts.RequestPermission()
            }
            mSocket = device.createRfcommSocketToServiceRecord(UUID.fromString(uuid))
        } catch (e: IOException) {
        }
    }

    override fun run() {
        try {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityResultContracts.RequestPermission()
            }
            listener.onReceive("Connecting...")
            mSocket?.connect()
            listener.onReceive("Connected")
            rThread = ReceiveThread(mSocket!!, listener)
            rThread.start()

        } catch (e: IOException) {
            listener.onReceive("Can not connect to device")
            closeConnection()
        }
    }

    private fun closeConnection() {
        try {
            mSocket?.close()
        } catch (e: IOException) {
        }
    }
}