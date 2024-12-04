package com.erdemyesilcicek.flokii.pages.settingspages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.erdemyesilcicek.flokii.createtalesections.TextSection

@Composable
fun DarkModeSheetContent(onOptionSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextSection("Dark Mode")
        listOf("Enable", "Disable").forEach { option ->
            TextButton(onClick = { onOptionSelected(option) }) {
                Text(option)
            }
        }
    }
}