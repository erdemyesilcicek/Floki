package com.erdemyesilcicek.flokii.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Audiotrack
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material3.AlertDialogDefaults.containerColor
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.erdemyesilcicek.flokii.bar.AppBar
import com.erdemyesilcicek.flokii.datas.myFont

@Composable
fun ReadTaleScreen(navController: NavController) {
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
                    imageVector = Icons.Rounded.Audiotrack,
                    contentDescription = "Listen to Tale",
                    tint = Color.White)
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
        ){
            Text(
                modifier = Modifier.padding(20.dp),
                text = "1914 translation by H. Rackham",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = myFont,
                textAlign = TextAlign.Center)

            Icon(imageVector = Icons.Rounded.AutoFixHigh, contentDescription = "magic")

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(1){
                    Text(
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.Normal,
                        fontFamily = myFont,
                        fontSize = 20.sp,
                        text = "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."

                    )

                }
            }
        }
    }
}