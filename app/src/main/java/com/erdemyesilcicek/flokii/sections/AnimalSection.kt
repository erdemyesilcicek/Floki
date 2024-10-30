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
import androidx.compose.ui.graphics.Color
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

val animalCards = listOf(
    DataCardSection(
        R.drawable.animalsbear,
        "Bear"
    ),
    DataCardSection(
        R.drawable.animalsboar,
        "Boar"
    ),
    DataCardSection(
        R.drawable.animalscamel,
        "Camel"
    ),
    DataCardSection(
        R.drawable.animalscat,
        "Cat"
    ),
    DataCardSection(
        R.drawable.animalschicken,
        "Chicken"
    ),
    DataCardSection(
        R.drawable.animalscow,
        "Cow"
    ),
    DataCardSection(
        R.drawable.animalscrocodile,
        "Crocodile"
    ),
    DataCardSection(
        R.drawable.animalsdog,
        "Dog"
    ),
    DataCardSection(
        R.drawable.animalselephant,
        "Elephant"
    ),
    DataCardSection(
        R.drawable.animalsfox,
        "Fox"
    ),
    DataCardSection(
        R.drawable.animalslion,
        "Lion"
    ),
    DataCardSection(
        R.drawable.animalsmonkey,
        "Monkey"
    ),
    DataCardSection(
        R.drawable.animalsseal,
        "Seal"
    ),
    DataCardSection(
        R.drawable.animalswolf,
        "Wolf"
    )
)

@Preview
@Composable
fun AnimalSection() {
    LazyRow {
        items(animalCards.size) { index ->
            AnimalCardItem(index)
        }
    }
}

@Composable
fun AnimalCardItem(index: Int) {
    val card = animalCards[index]

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
                                if (text == "Bear") {
                                    println("Bear Clicked")
                                } else if (text == "Boar") {
                                    println("Boar Clicked")
                                } else if (text == "Camel") {
                                    println("Camel Clicked")
                                } else if (text == "Cat") {
                                    println("Cat Clicked")
                                }
                                else if (text == "Chicken") {
                                    println("Chicken Clicked")
                                }
                                else if (text == "Cow") {
                                    println("Cow Clicked")
                                }
                                else if (text == "Crocodile") {
                                    println("Crocodile Clicked")
                                }
                                else if (text == "Dog") {
                                    println("Dog Clicked")
                                }
                                else if (text == "Elephant") {
                                    println("Elephant Clicked")
                                }
                                else if (text == "Fox") {
                                    println("Fox Clicked")
                                }
                                else if (text == "Lion") {
                                    println("Lion Clicked")
                                }
                                else if (text == "Monkey") {
                                    println("Monkey Clicked")
                                }
                                else if (text == "Seal") {
                                    println("Seal Clicked")
                                }
                                else if (text == "Wolf") {
                                    println("Wolf Clicked")
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