package com.erdemyesilcicek.flokii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erdemyesilcicek.flokii.datas.Card
import com.erdemyesilcicek.flokii.datas.Tale
import com.erdemyesilcicek.flokii.pages.CreateTaleScreen
import com.erdemyesilcicek.flokii.pages.MyTalesScreen
import com.erdemyesilcicek.flokii.pages.ReadTaleScreen
import com.erdemyesilcicek.flokii.pages.Settings
import com.erdemyesilcicek.flokii.pages.settingspages.FamilyInformation
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
        composable(route = "Settings") {
            Settings(navController)
        }
        composable(route = "FamilyInformation") {
            FamilyInformation(navController)
        }

        composable("ReadTaleScreen" + "?id={id}", arguments = listOf(navArgument("id") {
            type = NavType.IntType
            defaultValue = -1
        })) {
            val id = it.arguments?.getInt("id")!!
            ReadTaleScreen(navController, id)
        }
        composable(route = "Card") {
            Card(navController, card = Tale(5, "", "", 0))
        }
    }
}