package com.example.all_neco_lessons.bluetooth_monitor

import android.bluetooth.BluetoothSocket
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReceiveThread(
    bSocket: BluetoothSocket,
    private val listener: Listener
) : Thread() {
    private var inStream: InputStream? = null
    private var outStream: OutputStream? = null

    init {
        try {
            inStream = bSocket.inputStream
        } catch (e: IOException) {
        }

        try {
            outStream = bSocket.outputStream
        } catch (e: IOException) {
        }
    }

    override fun run() {
        val buffer = ByteArray(256)
        while (true) {
            try {
                val size = inStream?.read(buffer)
                val message = String(buffer, 0, size!!)
                listener.onReceive(message)
            } catch (e: IOException) {
                listener.onReceive("Connection lost")
                break
            }
        }
    }

    fun sendMessage(byteArray: ByteArray) {
        try {
            outStream?.write(byteArray)
        } catch (e: IOException) {
        }
    }

    interface Listener {
        fun onReceive(message: String)
    }
}