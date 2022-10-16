package com.example.all_neco_lessons.bluetooth_monitor

import java.io.Serializable

data class ListItem(
    var name: String,
    var mac: String
) : Serializable