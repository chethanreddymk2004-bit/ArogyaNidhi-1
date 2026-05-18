package com.example.arogyanidhiai1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Hospital(val name: String, val location: String)

@Composable
fun HospitalScreen(onBack: () -> Unit) {
    val scrollState = rememberScrollState()

    val hospitals = listOf(
        Hospital("Victoria Government Hospital", "Kalasipalyam, Bengaluru"),
        Hospital("Bowring and Lady Curzon Hospital", "Shivajinagar, Bengaluru"),
        Hospital("KC General Hospital", "Malleswaram, Bengaluru"),
        Hospital("Jayanagar General Hospital", "Jayanagar 4th Block, Bengaluru"),
        Hospital("NIMHANS", "Hosur Road, Bengaluru"),
        Hospital("Kidwai Memorial Institute of Oncology", "Dr. M.H. Marigowda Road, Bengaluru"),
        Hospital("Jayadeva Institute of Cardiovascular Sciences", "Jayanagar 9th Block, Bengaluru"),
        Hospital("Indira Gandhi Institute of Child Health", "Siddapura, Bengaluru"),
        Hospital("St. John's Medical College Hospital", "Koramangala, Bengaluru"),
        Hospital("Sanjay Gandhi Institute of Trauma", "Byrasandra, Bengaluru")
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Empanelled Hospitals",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            hospitals.forEach { hospital ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = hospital.name,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Location: ${hospital.location}",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { onBack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Back")
            }
        }
    }
}
