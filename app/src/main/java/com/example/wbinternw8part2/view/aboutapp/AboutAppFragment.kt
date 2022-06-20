package com.example.wbinternw8part2.view.aboutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wbinternw8part2.R
import com.example.wbinternw8part2.app.App.Companion.router
import com.example.wbinternw8part2.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment(R.layout.fragment_about_app) {

    private lateinit var binding: FragmentAboutAppBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutAppBinding.bind(view)

        binding.alphaContainer.setOnClickListener {
            router.exit()
        }

        binding.accept.setOnClickListener {
            router.exit()
        }
    }
}