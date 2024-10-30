package com.erdemyesilcicek.flokii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erdemyesilcicek.flokii.pages.CreateTaleScreen
import com.erdemyesilcicek.flokii.pages.MyTalesScreen
import com.erdemyesilcicek.flokii.ui.theme.FlokiiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlokiiTheme {
                NavController()
            }
        }
    }
}

@Composable
fun NavController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "MyTalesScreen"
    ) {
        composable(route = "MyTalesScreen") {
            MyTalesScreen(navController)
        }
        composable(route = "CreateTaleScreen") {
            CreateTaleScreen(navController)
        }
    }
}