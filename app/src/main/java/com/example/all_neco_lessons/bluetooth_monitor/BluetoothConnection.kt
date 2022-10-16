package com.example.all_neco_lessons.bluetooth_monitor

import android.bluetooth.BluetoothAdapter
import android.content.Context

class BluetoothConnection(
    private val adapter: BluetoothAdapter,
    private val context: Context,
    private val listener: ReceiveThread.Listener
) {
    private lateinit var cThread: ConnectThread
    fun connect(mac: String) {
        if (adapter.isEnabled && mac.isNotEmpty()) {
            val device = adapter.getRemoteDevice(mac)
            device.let {
                cThread = ConnectThread(it, context, listener)
                cThread.start()
            }
        }
    }

    fun sendMessage(message: String) {
        cThread.rThread.sendMessage(message.toByteArray())
    }
}