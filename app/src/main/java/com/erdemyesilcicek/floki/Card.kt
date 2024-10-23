package com.erdemyesilcicek.floki

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.floki.ui.theme.FlokiTheme

@Composable
fun Card() {
    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable { println("clickable clicked") }
                .fillMaxSize()
                .padding(2.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp),
                contentDescription = "Cards Photo",
                alignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .padding()
            )

            Text(
                text = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem " +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum" +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum ipsum ipsum",
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(15.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    FlokiTheme {
        Card()
    }
}