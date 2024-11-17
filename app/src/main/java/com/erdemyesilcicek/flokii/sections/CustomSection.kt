package com.erdemyesilcicek.flokii.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.flokii.datas.CustomCardItem
import com.erdemyesilcicek.flokii.datas.DataCardSection
import com.erdemyesilcicek.flokii.datas.myFont

@Composable
fun CustomSection(list: List<DataCardSection>, isMultiple: Boolean) {

    val selectedButtons = remember { mutableStateListOf<Int>() }

    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        LazyRow {
            itemsIndexed(list) { index, item ->
                CustomCardItem(
                    index = index,
                    item = item,
                    isSelected = selectedButtons.contains(index),
                    onClick = {
                        if (selectedButtons.contains(index)) {
                            selectedButtons.remove(index)
                        } else {
                            if (isMultiple && selectedButtons.size < 3) {
                                selectedButtons.add(index)
                            } else if (!isMultiple && selectedButtons.size < 1) {
                                selectedButtons.add(index)
                            }
                        }
                    }
                )
            }
        }
    }
}