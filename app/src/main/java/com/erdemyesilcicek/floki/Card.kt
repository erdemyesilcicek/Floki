package com.erdemyesilcicek.floki

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.floki.ui.theme.FlokiTheme

@Composable
fun TextSection() {
    Text(
        text = "Dede Korkut Hikayeleri",
        color = Color.Magenta,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    )

}

@Composable
fun Card() {
    TextSection()
    OutlinedCard(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
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
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .padding(5.dp),
                maxLines = 4,
                text = "lorem ipsum lorem ipsum lorem ipsum lorem " +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum " +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum " +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum " +
                        "ipsum lorem ipsum lorem ipsum lorem ipsum",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary
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