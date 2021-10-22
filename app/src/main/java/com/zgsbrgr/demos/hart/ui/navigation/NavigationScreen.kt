package com.zgsbrgr.demos.hart.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument



sealed class NavigationScreen(val route: String, val arguments: List<NamedNavArgument>) {

    object ExhibitionList: NavigationScreen(
        route = "exhibitionList",
        arguments = emptyList()
    )

    object ExhibitionDetail: NavigationScreen(
        route = "exhibitionDetail",
        arguments = listOf(navArgument("exhibitionId") {
            type = NavType.IntType
        })
    )

}

class MainActions(navController: NavController) {
    val navigateToExhibitionDetail: (Int) -> Unit = { exhibitionId: Int ->
        navController.navigate("${NavigationScreen.ExhibitionDetail.route}/$exhibitionId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}