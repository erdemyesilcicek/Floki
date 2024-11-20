package com.erdemyesilcicek.flokii.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.erdemyesilcicek.flokii.customitems.CustomCardItem
import com.erdemyesilcicek.flokii.datas.DataCardSection

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