package com.example.arogyanidhiai1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onStartClick: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome to Arogya Nidhi AI", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { onStartClick() }) {
                Text(text = "Start Eligibility Check")
            }
        }
    }
}