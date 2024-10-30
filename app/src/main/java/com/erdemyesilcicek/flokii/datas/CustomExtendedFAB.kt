package com.erdemyesilcicek.flokii.datas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ExtendedFAB(
    containerColor: Color,
    icon: ImageVector,
    contentDescription: String,
    text: String,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        containerColor = containerColor,
        elevation = FloatingActionButtonDefaults.elevation(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(80.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = myFont
            )
        }
    }
}