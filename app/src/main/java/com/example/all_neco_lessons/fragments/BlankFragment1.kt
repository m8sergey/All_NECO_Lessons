package com.example.all_neco_lessons.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.all_neco_lessons.databinding.FragmentBlank1FragmentsBinding

class BlankFragment1 : Fragment() {
    private lateinit var binding: FragmentBlank1FragmentsBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlank1FragmentsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSendF2.setOnClickListener {
            dataModel.messageForF2.value = "Hello from Fragment1"
        }

        binding.btnSendA.setOnClickListener {
            dataModel.messageForA.value = "Hello Activity from Fragment1"
        }

        dataModel.messageForF1.observe(activity as LifecycleOwner) {
            binding.txt.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment1()
    }
}