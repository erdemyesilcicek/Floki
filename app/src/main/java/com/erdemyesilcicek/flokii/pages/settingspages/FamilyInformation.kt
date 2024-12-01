package com.erdemyesilcicek.flokii.pages.settingspages

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.R
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.createtalesections.TextSection

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
            Image(
                painter = painterResource(id = R.drawable.logoapp),
                contentDescription = "",
                contentScale = ContentScale.Fit)
            Text(text ="Family Information")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(1) {
                    TextInputExample("Name","Enter Name")
                    TextInputExample("Age","Enter Age")
                    TextInputExample("Gender","Enter Gender")
                    TextInputExample("Name","Enter Name")
                    TextInputExample("Dad's Name","Enter Dad's Name")
                    TextInputExample("Mom's Name","Enter Mom's Name")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputExample(title : String, label: String) {
    val text = remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextSection(title = title)

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
                    MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(20.dp)
                ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedLabelColor =
                if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
                unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
            ),
        )
    }
}