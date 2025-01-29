package com.example.randomnames.ui.randomnamesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.randomnames.databinding.FragmentNameDetailBinding
import com.example.randomnames.models.Results

class NameDetailsFragment : Fragment() {

    private var fragmentNameDetailBinding: FragmentNameDetailBinding? = null
    private val binding get() = fragmentNameDetailBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentNameDetailBinding = FragmentNameDetailBinding.inflate(inflater, container, false)

        val user = arguments?.getSerializable("user") as? Results

        binding.nameDetail.text = user?.name?.let { "${it.title} ${it.first} ${it.last}" }
            ?: "No Name Available"

        binding.backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentNameDetailBinding = null
    }
}