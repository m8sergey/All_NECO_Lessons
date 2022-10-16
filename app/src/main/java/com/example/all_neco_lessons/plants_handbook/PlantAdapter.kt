package com.example.all_neco_lessons.plants_handbook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.all_neco_lessons.R
import com.example.all_neco_lessons.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    private val plantList = ArrayList<Plant>()

    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding) {
            image.setImageResource(plant.imageId)
            txtTitle.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.plant_item,
            parent,
            false
        )
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}