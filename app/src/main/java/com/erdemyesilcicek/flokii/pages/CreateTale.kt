package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.erdemyesilcicek.flokii.datas.ExtendedFAB
import com.erdemyesilcicek.flokii.datas.myFont
import com.erdemyesilcicek.flokii.sections.AnimalSection
import com.erdemyesilcicek.flokii.sections.CharacterSection
import com.erdemyesilcicek.flokii.sections.FamilySection
import com.erdemyesilcicek.flokii.sections.GenreSection
import com.erdemyesilcicek.flokii.sections.SeasonSection
import com.erdemyesilcicek.flokii.sections.TextSection

@Composable
fun CreateTaleScreen(navController: NavController) {
    Scaffold(
        topBar = { AppBar(isHomeScreen = false, "Create Tale", navController) },
        modifier = Modifier.fillMaxSize(),

        floatingActionButton = {
            ExtendedFAB(
                MaterialTheme.colorScheme.primary,
                Icons.Rounded.AutoFixHigh,
                "Create a tale icon",
                " Create Tale",
                onClick = {
                    println("create tale screen fab clicked")
                })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(1) {
                TextSection("Genre")
                GenreSection()

                Spacer(modifier = Modifier.padding(5.dp))

                TextSection("Season")
                SeasonSection()

                Spacer(modifier = Modifier.padding(5.dp))

                TextSection("Animal")
                AnimalSection()

                Spacer(modifier = Modifier.padding(5.dp))

                TextSection("Character")
                CharacterSection()

                Spacer(modifier = Modifier.padding(5.dp))

                TextSection("Include in the tale")
                FamilySection()

                Spacer(modifier = Modifier.padding(50.dp))

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
