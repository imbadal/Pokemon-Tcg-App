package com.android.pokemontcg.presentation.ui.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortBottomSheet(
    onDismiss: () -> Unit,
    onSortOptionSelected: (SortOption) -> Unit,
    selectedSortOption: SortOption
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Sort by",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            SortOptionItem(
                text = "Level (A-Z)",
                onClick = {
                    onSortOptionSelected(SortOption.LevelAsc)
                    onDismiss()
                },
                isSelected = selectedSortOption == SortOption.LevelAsc
            )
            SortOptionItem(
                text = "Level (Z-A)",
                onClick = {
                    onSortOptionSelected(SortOption.LevelDesc)
                    onDismiss()
                },
                isSelected = selectedSortOption == SortOption.LevelDesc
            )
            SortOptionItem(
                text = "HP (Ascending)",
                onClick = {
                    onSortOptionSelected(SortOption.HpAsc)
                    onDismiss()
                },
                isSelected = selectedSortOption == SortOption.HpAsc
            )
            SortOptionItem(
                text = "HP (Descending)",
                onClick = {
                    onSortOptionSelected(SortOption.HpDesc)
                    onDismiss()
                },
                isSelected = selectedSortOption == SortOption.HpDesc
            )
        }
    }
}

@Composable
private fun SortOptionItem(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.weight(1f))
        RadioButton(
            selected = isSelected,
            onClick = onClick
        )
    }
}

enum class SortOption {
    LevelAsc,
    LevelDesc,
    HpAsc,
    HpDesc
}