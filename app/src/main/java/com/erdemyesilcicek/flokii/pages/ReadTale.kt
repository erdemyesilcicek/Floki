package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Audiotrack
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
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
import com.erdemyesilcicek.flokii.lists.TaleList
import com.erdemyesilcicek.flokii.datas.myFont

@Composable
fun ReadTaleScreen(navController: NavController, id: Int?) {
    val tale = TaleList.get(id!!)

    Scaffold(
        topBar = { AppBar(isHomeScreen = false, "My Tales", navController) },
        modifier = Modifier.fillMaxSize(),

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(10.dp),
                modifier = Modifier
                    .padding(20.dp),
            ) {
                Icon(
                    modifier = Modifier.padding(20.dp),
                    imageVector = Icons.Rounded.Audiotrack,
                    contentDescription = "Listen to Tale",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = tale.title,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = myFont,
                textAlign = TextAlign.Center
            )

            Icon(imageVector = Icons.Rounded.AutoFixHigh, contentDescription = "magic")

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(1) {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.Normal,
                        fontFamily = myFont,
                        fontSize = 20.sp,
                        text = tale.content
                    )
                    Spacer(modifier = Modifier.padding(20.dp))

                    Row(
                        modifier = Modifier.fillParentMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Created by Erdem",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = myFont,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}