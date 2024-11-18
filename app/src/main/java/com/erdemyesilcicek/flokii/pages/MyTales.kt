package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.datas.Card
import com.erdemyesilcicek.flokii.datas.ExtendedFAB
import com.erdemyesilcicek.flokii.datas.TaleList
import com.erdemyesilcicek.flokii.datas.myFont

@Composable
fun MyTalesScreen(navController: NavController) {

    Scaffold(
        topBar = { AppBar(isHomeScreen = true, "My Tales", navController) },
        modifier = Modifier.fillMaxSize(),

        floatingActionButton = {
            ExtendedFAB(
                MaterialTheme.colorScheme.primary,
                Icons.Rounded.AutoFixHigh,
                "Create a tale icon",
                " Create Tale",
                onClick = {
                    navController.navigate("CreateTaleScreen")
                })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(TaleList) { index, card ->
                    Card(navController, card)
                }
            }
        }
    }
}
