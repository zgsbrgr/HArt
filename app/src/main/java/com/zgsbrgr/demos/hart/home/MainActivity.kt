package com.zgsbrgr.demos.hart.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import coil.ImageLoader
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zgsbrgr.demos.hart.ui.navigation.NavigationScreen
import com.zgsbrgr.demos.hart.ui.theme.ZComposeTheme
import com.zgsbrgr.demos.hart.ui_exhibitonlist.ExhibitionList
import com.zgsbrgr.demos.hart.ui_exhibitonlist.ExhibitionListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue



@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZComposeTheme {
                BoxWithConstraints {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = NavigationScreen.ExhibitionList.route,
                        builder = {
                            addExhibitionList(
                                navController = navController,
                                imageLoader = imageLoader,
                                width = constraints.maxWidth / 2

                            )
                        }
                    )
                }
            }
        }
    }

}


@ExperimentalAnimationApi
fun NavGraphBuilder.addExhibitionList(
    navController: NavController,
    imageLoader: ImageLoader,
    width: Int
) {
    composable(
        route = NavigationScreen.ExhibitionList.route
    ) {
        val viewModel: ExhibitionListViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        ExhibitionList(
            state = uiState,
            navigateToDetailScreen = { exhibitionId ->
                navController.navigate("${NavigationScreen.ExhibitionDetail.route}/$exhibitionId")
            },
            imageLoader = imageLoader)

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