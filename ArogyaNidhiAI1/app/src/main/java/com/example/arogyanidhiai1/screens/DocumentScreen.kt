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
fun DocumentScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Required Documents", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "1. Aadhaar Card")
            Text(text = "2. Income Certificate")
            Text(text = "3. Ration Card (BPL)")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { onBack() }) {
                Text(text = "Back")
            }
        }
    }
}