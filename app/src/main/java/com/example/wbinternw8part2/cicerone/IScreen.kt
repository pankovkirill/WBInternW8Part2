package com.example.wbinternw8part2.cicerone

import com.example.wbinternw8part2.model.data.DataModel
import com.github.terrakok.cicerone.Screen

interface IScreen {
    fun showMainScreen(): Screen
    fun showDetailsScreen(dataModel: DataModel): Screen
    fun showAboutAppScreen(): Screen
}