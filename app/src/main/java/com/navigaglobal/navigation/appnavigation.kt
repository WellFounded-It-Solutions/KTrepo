package com.navigaglobal.navigation

class ModuleOptions {
    companion object {
        // Constants for module choices
        const val HOME = "Home"
        const val MY_KT = "My KT"
        const val GOLD_RATE = "Gold Rate"
        const val CENTERPOINT = "Centerpoint"
        const val EXPLORE = "Explore"

        // Default selected module
        const val DEFAULT_SELECTED_MODULE = HOME
    }

    // Mutable property to store the current selected module
    var currentSelectedModule: String = DEFAULT_SELECTED_MODULE
        private set  // Restricting external modification

    // Method to change the current selected module
    fun setCurrentSelectedModule(module: String) {
        currentSelectedModule = module
    }
}