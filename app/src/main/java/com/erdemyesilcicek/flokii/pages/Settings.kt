package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.InsertDriveFile
import androidx.compose.material.icons.outlined.PeopleAlt
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Translate
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.customitems.SettingsCard
import com.erdemyesilcicek.flokii.datas.dataclass.DataSettingsCard
import com.erdemyesilcicek.flokii.pages.settingspages.DarkModeSheetContent
import com.erdemyesilcicek.flokii.pages.settingspages.LanguageSheetContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(
    navController: NavController
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    var sheetContent by remember { mutableStateOf<@Composable () -> Unit>({}) }

    val settingsList = listOf<DataSettingsCard>(
        DataSettingsCard(
            imageVector = Icons.Outlined.PeopleAlt,
            contentDescription = "Family Information",
            itemText = "Family Information",
            onClick = { navController.navigate("FamilyInformation") }
        ),
        DataSettingsCard(
            imageVector = Icons.Outlined.Translate,
            contentDescription = "Language",
            itemText = "Language",
            onClick = {
                sheetContent = {
                    LanguageSheetContent { selectedLanguage ->
                        println("Selected Language: $selectedLanguage")
                        scope.launch { scaffoldState.bottomSheetState.hide() }
                    }
                }
                scope.launch { scaffoldState.bottomSheetState.expand() }
            }
        ),
        DataSettingsCard(
            imageVector = Icons.Outlined.Phone,
            contentDescription = "Feedback, Contact",
            itemText = "Contact",
            onClick = { navController.navigate("Feedback") }
        ),
        DataSettingsCard(
            imageVector = Icons.Outlined.DarkMode,
            contentDescription = "dark mode",
            itemText = "Dark Mode",
            onClick = {
                sheetContent = {
                    DarkModeSheetContent { selectedOption ->
                        println("Dark Mode: $selectedOption")
                        scope.launch { scaffoldState.bottomSheetState.hide() }
                    }
                }
                scope.launch { scaffoldState.bottomSheetState.expand() }
            }
        ),
        DataSettingsCard(
            imageVector = Icons.Outlined.PrivacyTip,
            contentDescription = "Privacy Policy",
            itemText = "Privacy Policy",
            onClick = { navController.navigate("PrivacyPolicy") }
        ),
        DataSettingsCard(
            imageVector = Icons.Outlined.InsertDriveFile,
            contentDescription = "Terms of Use",
            itemText = "Terms of Use",
            onClick = { navController.navigate("TermOfUse") }
        )
    )

    BottomSheetScaffold(
        sheetShadowElevation = 10.dp,
        sheetTonalElevation = 10.dp,
        sheetContainerColor = Color.White,
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        scaffoldState = scaffoldState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding()
                    .background(Color.White)
            ) {
                sheetContent()
            }
        },
        sheetPeekHeight = 0.dp,
    ) { innerPadding ->
        Scaffold(
            topBar = {
                AppBar(
                    isEnableBackButton = false,
                    isEnableBarButton = true,
                    "",
                    navController = navController
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
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
}