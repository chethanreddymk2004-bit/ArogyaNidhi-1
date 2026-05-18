package com.example.arogyanidhiai1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    isEligible: Boolean,
    onViewDocuments: () -> Unit,
    onFindHospitals: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Eligibility Result",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            if (isEligible) {
                Text(
                    text = "Congratulations!",
                    fontSize = 22.sp,
                    color = Color(0xFF2E7D32),
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "You are likely eligible for the scheme.",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(48.dp))

                Button(
                    onClick = { onViewDocuments() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "View Required Documents")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { onFindHospitals() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Find Empanelled Hospitals")
                }
            } else {
                Text(
                    text = "Not Eligible",
                    fontSize = 22.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Based on your answers, you may not meet the current criteria.",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}