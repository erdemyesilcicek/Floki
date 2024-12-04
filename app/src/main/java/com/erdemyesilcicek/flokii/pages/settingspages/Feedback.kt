package com.erdemyesilcicek.flokii.pages.settingspages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.R
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.customitems.ExtendedFAB
import com.erdemyesilcicek.flokii.customitems.TextInputExample

@Composable
fun Feedback(
    navController: NavController
) {
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
        floatingActionButton = {
            ExtendedFAB(
                MaterialTheme.colorScheme.primary,
                //Icons.Rounded.SaveAlt,
                "Feedback pages, send button.",
                "Send",
                onClick = {
                    println("Send fab clicked")
                })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = "How can we help you?",
                fontFamily = FontFamily.Default,
                fontSize = 22.sp
            )
            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(1) {
                    TextInputExample("Email", "Enter Email", true)
                    TextInputExample("Subject", "Enter Subject", true)
                    TextInputExample(
                        "Message",
                        "Enter Message",
                        true
                    )
                }
            }
        }
    }
}