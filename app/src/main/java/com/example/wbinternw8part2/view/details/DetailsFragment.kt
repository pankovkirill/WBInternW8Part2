package com.example.wbinternw8part2.view.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.wbinternw8part2.R
import com.example.wbinternw8part2.databinding.FragmentDetailsBinding
import com.example.wbinternw8part2.model.data.DataModel
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        renderData()
    }

    private fun renderData() {
        val data = arguments?.getParcelable<DataModel>(KEY)

        with(binding) {
            data?.let {
                Picasso
                    .with(context)
                    .load(data.images.md)
                    .error(R.drawable.ic_baseline_no_photography_24)
                    .into(binding.image)

                fullName.text = data.name
                intelligence.text = data.powerstats.intelligence.toString()
                strength.text = data.powerstats.strength.toString()
                speed.text = data.powerstats.speed.toString()
                durability.text = data.powerstats.durability.toString()
                power.text = data.powerstats.power.toString()
                combat.text = data.powerstats.combat.toString()

            }
        }
    }

    companion object {
        private const val KEY = "details"

        fun newInstance(data: DataModel) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, data)
            }
        }
    }
}