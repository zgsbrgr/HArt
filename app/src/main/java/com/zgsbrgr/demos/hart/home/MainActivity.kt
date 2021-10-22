package com.zgsbrgr.demos.hart.home

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import coil.ImageLoader
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zgsbrgr.demos.hart.ui.navigation.NavigationScreen
import com.zgsbrgr.demos.hart.common_ui_compose.theme.ZComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import coil.annotation.ExperimentalCoilApi
import com.zgsbrgr.demos.hart.R
import com.zgsbrgr.demos.hart.ui.navigation.MainActions
import com.zgsbrgr.demos.hart.ui_exhibition_detail.ExhibitionDetail
import com.zgsbrgr.demos.hart.ui_exhibition_detail.ExhibitionViewModel
import com.zgsbrgr.demos.hart.ui_exhibitionlist.ExhibitionList
import com.zgsbrgr.demos.hart.ui_exhibitionlist.ExhibitionListViewModel


@ExperimentalAnimationApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZComposeTheme {
                BoxWithConstraints(

                ) {

                    val navController = rememberAnimatedNavController()

                    AnimatedNavHost(
                        navController = navController,
                        startDestination = NavigationScreen.ExhibitionList.route,
                        builder = {
                            addExhibitionList(
                                navController = navController,
                                imageLoader = imageLoader,
                                resources = resources

                            )
                            addExhibitionDetail(
                                navController = navController,
                                imageLoader = imageLoader,
                                resources = resources
                            )

                        }
                    )
                }

            }
        }
    }

}



@ExperimentalCoilApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addExhibitionList(
    navController: NavController,
    imageLoader: ImageLoader,
    resources: Resources
) {
    composable(
        route = NavigationScreen.ExhibitionList.route
    ) {
        val actions = remember(navController) { MainActions(navController) }
        val viewModel: ExhibitionListViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        ExhibitionList(
            state = uiState,
            navigateToDetailScreen = actions.navigateToExhibitionDetail,
            imageLoader = imageLoader,
            resources = resources

        )

    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.addExhibitionDetail(
    navController: NavController,
    imageLoader: ImageLoader,
    resources: Resources
) {
    composable(
        route = NavigationScreen.ExhibitionDetail.route + "/{exhibitionId}",
        arguments = NavigationScreen.ExhibitionDetail.arguments
    ) {
        val actions = remember(navController) { MainActions(navController) }
        val viewModel: ExhibitionViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        ExhibitionDetail(
            state = uiState,
            imageLoader = imageLoader,
            onBack = actions.upPress,

        )
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZComposeTheme {
        Greeting("Android")
    }
}