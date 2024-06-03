package com.example.lab7_ph30902_ktl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab7_ph30902_ktl.Screens.ScreenNavigation

enum class ROUTE_NAME {
    main,
    bai1,
    bai2,
    bai3,
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())

    NavHost(navController = navController, startDestination = ROUTE_NAME.main.name) {
        composable(ROUTE_NAME.main.name) { baitap(navController) }
        composable(ROUTE_NAME.bai1.name) { MovieScreen(moviesState.value) }
        composable(ROUTE_NAME.bai2.name) { ScreenNavigation(navController) }


    }
}
