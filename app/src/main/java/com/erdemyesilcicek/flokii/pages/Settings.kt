package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.InsertDriveFile
import androidx.compose.material.icons.rounded.PeopleAlt
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.customitems.SettingsCard
import com.erdemyesilcicek.flokii.datas.dataclass.DataSettingsCard

@Composable
fun Settings(navController: NavController) {

    val settingsList = listOf<DataSettingsCard>(
        DataSettingsCard(
            imageVector = Icons.Rounded.PeopleAlt,
            contentDescription = "Family Information",
            itemText = "Family Information",
            onClick = { navController.navigate("FamilyInformation") }
        ),
        DataSettingsCard(
            imageVector = Icons.Rounded.Translate,
            contentDescription = "Language",
            itemText = "Language",
            onClick = { println("Language Clicked") }
        ),
        DataSettingsCard(
            imageVector = Icons.Rounded.Phone,
            contentDescription = "Feedback",
            itemText = "Feedback",
            onClick = { println("Feedback Clicked") }
        ),
        DataSettingsCard(
            imageVector = Icons.Rounded.DarkMode,
            contentDescription = "dark mode",
            itemText = "Dark Mode",
            onClick = { println("Dark Mode Clicked") }
        ),
        DataSettingsCard(
            imageVector = Icons.Rounded.PrivacyTip,
            contentDescription = "Privacy Policy",
            itemText = "Privacy Policy",
            onClick = { println("Privacy Policy Clicked") }
        ),
        DataSettingsCard(
            imageVector = Icons.Rounded.InsertDriveFile,
            contentDescription = "Terms of Use",
            itemText = "Terms of Use",
            onClick = { println("Terms of Use Clicked") }
        )
    )

    Scaffold(
        topBar = {
            AppBar(
                isEnableBackButton = false,
                isEnableBarButton = true,
                "",
                navController
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.Top
            ) {
                items(settingsList.size) { index ->
                    SettingsCard(
                        imageVector = settingsList[index].imageVector,
                        contentDescription = settingsList[index].contentDescription,
                        itemText = settingsList[index].itemText,
                        onClick = settingsList[index].onClick
                    )
                }
            }
        }
    }
}