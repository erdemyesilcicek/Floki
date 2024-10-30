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
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    val myButtonColor = colorScheme.primary

    val image = card.image
    val text = card.text
    var buttonColor by remember { mutableStateOf(Color.White) }

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
                    .background(buttonColor),
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
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Bear Clicked")
                                } else if (text == "Boar") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Boar Clicked")
                                } else if (text == "Camel") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Camel Clicked")
                                } else if (text == "Cat") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Cat Clicked")
                                }
                                else if (text == "Chicken") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Chicken Clicked")
                                }
                                else if (text == "Cow") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Cow Clicked")
                                }
                                else if (text == "Crocodile") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Crocodile Clicked")
                                }
                                else if (text == "Dog") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Dog Clicked")
                                }
                                else if (text == "Elephant") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Elephant Clicked")
                                }
                                else if (text == "Fox") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Fox Clicked")
                                }
                                else if (text == "Lion") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Lion Clicked")
                                }
                                else if (text == "Monkey") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Monkey Clicked")
                                }
                                else if (text == "Seal") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
                                    println("Seal Clicked")
                                }
                                else if (text == "Wolf") {
                                    buttonColor = if (buttonColor == Color.White) myButtonColor else Color.White
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