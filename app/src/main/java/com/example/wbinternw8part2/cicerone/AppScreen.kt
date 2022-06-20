package com.example.wbinternw8part2.cicerone

import com.example.wbinternw8part2.model.data.DataModel
import com.example.wbinternw8part2.view.aboutapp.AboutAppFragment
import com.example.wbinternw8part2.view.details.DetailsFragment
import com.example.wbinternw8part2.view.main.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreen : IScreen {
    override fun showMainScreen() = FragmentScreen {
        MainFragment()
    }

    override fun showDetailsScreen(dataModel: DataModel) = FragmentScreen {
        DetailsFragment.newInstance(dataModel)
    }

    override fun showAboutAppScreen() = FragmentScreen {
        AboutAppFragment()
    }
}