package com.erdemyesilcicek.flokii.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.flokii.R
import com.erdemyesilcicek.flokii.datas.DataCardSection
import com.erdemyesilcicek.flokii.datas.myFont

val genreCards = listOf(
    DataCardSection(
        R.drawable.genreadventure,
        "Adventure"
    ),
    DataCardSection(
        R.drawable.genrefantastic,
        "Fantastic"
    ),
    DataCardSection(
        R.drawable.genremystery,
        "Mystery"
    ),
    DataCardSection(
        R.drawable.genrespace,
        "Space"
    ),
    DataCardSection(
        R.drawable.genretrip,
        "Trip"
    ),
    DataCardSection(
        R.drawable.genrefamily,
        "Family"
    ),
)

@Preview
@Composable
fun GenreSection() {
    LazyRow {
        items(genreCards.size) { index ->
            GenreCardItem(index)
        }
    }
}

@Composable
fun GenreCardItem(index: Int) {
    val card = genreCards[index]

    val image = card.image
    val text = card.text

    Column(
        modifier = Modifier
            .padding(start = 10.dp, 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(start = 10.dp, 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(100.dp)
                    .height(100.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(image),
                    contentDescription = "logos",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable Image",
                            onClick = {
                                if (text == "Adventure") {
                                    println("Adventure Clicked")
                                } else if (text == "Fantastic") {
                                    println("Fantastic Clicked")
                                } else if (text == "Mystery") {
                                    println("Mystery Clicked")
                                } else if (text == "Space") {
                                    println("Space Clicked")
                                } else if (text == "Trip") {
                                    println("Trip Clicked")
                                } else if (text == "Family") {
                                    println("Family Clicked")
                                }
                            }
                        )
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = myFont
        )
    }
}