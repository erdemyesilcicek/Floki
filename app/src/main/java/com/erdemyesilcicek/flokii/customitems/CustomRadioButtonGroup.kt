package com.erdemyesilcicek.flokii.customitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
            CustomRadioButton(
                text = option,
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) }
            )
        }
    }
}