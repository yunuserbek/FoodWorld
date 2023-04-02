package com.food.foodworld.utility

import com.food.domain.model.Menu
import com.food.foodworld.R

object customData {
    fun getMenu(): List<Menu> {
        return listOf(
            Menu(0, (R.drawable.sunnysideup), "Breakfast", R.color.opaqueOverlay),

        )
    }
}