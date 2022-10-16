package com.example.all_neco_lessons.bluetooth_monitor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.BluetoothMonitorListItemBinding

class RcAdopter(private val listener: Listener) :
    ListAdapter<ListItem, RcAdopter.ItemHolder>(ItemComparator()) {

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = BluetoothMonitorListItemBinding.bind(view)
        fun setData(item: ListItem, listener: Listener) = with(binding) {
            txtName.text = item.name
            txtMac.text = item.mac
            itemView.setOnClickListener {
                listener.onClick(item)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.bluetooth_monitor_list_item, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.mac == newItem.mac
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent = parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    interface Listener {
        fun onClick(item: ListItem)
    }
}