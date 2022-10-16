package com.example.all_neco_lessons.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.all_neco_lessons.databinding.FragmentBlank2FragmentsBinding

class BlankFragment2 : Fragment() {
    private lateinit var binding: FragmentBlank2FragmentsBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank2FragmentsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSendF1.setOnClickListener {
            dataModel.messageForF1.value = "Hello from Fragment2"
        }

        binding.btnSendA.setOnClickListener {
            dataModel.messageForA.value = "Hello Activity from Fragment2"
        }

        dataModel.messageForF2.observe(activity as LifecycleOwner) {
            binding.txt.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}