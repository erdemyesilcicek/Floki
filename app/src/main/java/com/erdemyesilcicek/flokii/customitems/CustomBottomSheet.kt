package com.erdemyesilcicek.flokii.customitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable () -> Unit,
    bottomSheetState: SheetState = rememberModalBottomSheetState(true),
    scope: CoroutineScope = rememberCoroutineScope()
) {
    ModalBottomSheet(
        sheetState = bottomSheetState,
        onDismissRequest = {
            scope.launch { bottomSheetState.hide() }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                sheetContent()
            }
        }
    )
}
