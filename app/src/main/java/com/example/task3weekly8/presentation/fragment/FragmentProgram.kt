package com.example.task3weekly8.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.task3weekly8.R
import com.example.task3weekly8.databinding.FragmentProgramBinding

class FragmentProgram : Fragment
    (R.layout.fragment_program) {

    private lateinit var binding: FragmentProgramBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProgramBinding.bind(view)

        binding.accept.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}