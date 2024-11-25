package com.erdemyesilcicek.flokii.pages.settingspages

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar

@Composable
fun FamilyInformation(
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppBar(
                isHomeScreen = false,
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
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(1) {
                    TextInputExample("Your Name")
                    TextInputExample("Dad Name")
                    TextInputExample("Mom Name")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputExample(label: String) {
    val text = remember { mutableStateOf("") }
    TextField(
        singleLine = true,
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(text = label) },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(
                1.dp,
                if (text.value != "") {
                    MaterialTheme.colorScheme.primary
                }else{
                    MaterialTheme.colorScheme.onBackground
                },
                shape = RoundedCornerShape(20.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            // Arka plan rengi
            containerColor = Color.White, // TextField arka plan rengi
            // Odaklandığında değişecek renk
            focusedIndicatorColor = Color.White, // Odaklandığında alt çizgi rengi
            // Odaklanmadığında alt çizgi rengi
            unfocusedIndicatorColor = Color.White, // Odaklanmadığında alt çizgi rengi
            // Girilen metnin rengi
            cursorColor = MaterialTheme.colorScheme.primary,
            // Etiket rengi
            focusedLabelColor = MaterialTheme.colorScheme.primary, // Odaklanınca etiket rengi
            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground, // Odaklanmayınca etiket rengi
        )
    )
}