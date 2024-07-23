package com.android.pokemontcg.presentation.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun ShimmerLayoutHome() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .background(Color.Gray.copy(alpha = 0.3f))
                    .placeholder(
                        visible = true,
                        color = Color.Gray.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.4f)
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .placeholder(
                                visible = true,
                                color = Color.Gray.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.3f)
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .placeholder(
                                visible = true,
                                color = Color.Gray.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.3f)
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .placeholder(
                                visible = true,
                                color = Color.Gray.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(0.2f)
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .placeholder(
                                visible = true,
                                color = Color.Gray.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
