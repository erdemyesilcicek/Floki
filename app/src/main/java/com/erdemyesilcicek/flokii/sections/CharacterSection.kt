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

val characterCards = listOf(
    DataCardSection(
        R.drawable.characterschef,
        "Chef"
    ),
    DataCardSection(
        R.drawable.charactersclown,
        "Clown"
    ),
    DataCardSection(
        R.drawable.characterscowboy,
        "Cowboy"
    ),
    DataCardSection(
        R.drawable.charactersdwarf,
        "Dwarf"
    ),
    DataCardSection(
        R.drawable.characterself,
        "Elf"
    ),
    DataCardSection(
        R.drawable.charactersking,
        "King"
    ),
    DataCardSection(
        R.drawable.charactersninja,
        "Ninja"
    ),
    DataCardSection(
        R.drawable.characterspirate,
        "Pirate"
    ),
    DataCardSection(
        R.drawable.charactersthief,
        "Thief"
    ),
    DataCardSection(
        R.drawable.characterswizard,
        "Wizard"
    ),
)

@Preview
@Composable
fun CharacterSection() {
    LazyRow {
        items(characterCards.size) { index ->
            CharacterCardItem(index)
        }
    }
}

@Composable
fun CharacterCardItem(index: Int) {
    val card = characterCards[index]

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
                                if (text == "Chef") {
                                    println("Chef Clicked")
                                } else if (text == "Clown") {
                                    println("Clown Clicked")
                                } else if (text == "Cowboy") {
                                    println("Cowboy Clicked")
                                } else if (text == "Dwarf") {
                                    println("Dwarf Clicked")
                                } else if (text == "Elf") {
                                    println("Elf Clicked")
                                } else if (text == "King") {
                                    println("King Clicked")
                                } else if (text == "Ninja") {
                                    println("Ninja Clicked")
                                } else if (text == "Pirate") {
                                    println("Pirate Clicked")
                                } else if (text == "Thief") {
                                    println("Thief Clicked")
                                } else if (text == "Wizard") {
                                    println("Wizard Clicked")
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