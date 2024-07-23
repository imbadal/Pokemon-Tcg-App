package com.android.pokemontcg.presentation.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.android.pokemontcg.presentation.ui.bottomsheet.SortBottomSheet
import com.android.pokemontcg.presentation.ui.bottomsheet.SortOption

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBar(
    searchQuery: MutableState<TextFieldValue>,
    isSearchEnabled: MutableState<Boolean>,
    onSortOptionSelected: (SortOption) -> Unit,
    selectedSortOption: SortOption,
    lastSyncTime: String?
) {
    var showSortSheet by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            if (isSearchEnabled.value) {
                TextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    placeholder = { Text(text = "Search Pokémon") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        cursorColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    trailingIcon = {
                        IconButton(onClick = {
                            searchQuery.value = TextFieldValue("")
                            isSearchEnabled.value = false
                        }) {
                            Icon(Icons.Filled.Close, contentDescription = "Cancel")
                        }
                    }
                )
            } else {
                Column {
                    Text(text = "Pokémon Cards")
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Last Sync: $lastSyncTime",
                        style = MaterialTheme.typography.labelSmall
                    )
                }

            }
        },
        actions = {
            if (!isSearchEnabled.value) {
                IconButton(onClick = { isSearchEnabled.value = true }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
                IconButton(onClick = { showSortSheet = true }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "Filter")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )

    if (showSortSheet) {
        SortBottomSheet(
            onDismiss = { showSortSheet = false },
            onSortOptionSelected = onSortOptionSelected,
            selectedSortOption = selectedSortOption
        )
    }
}
