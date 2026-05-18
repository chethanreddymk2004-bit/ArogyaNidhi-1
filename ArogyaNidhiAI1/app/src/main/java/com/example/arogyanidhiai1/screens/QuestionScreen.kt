package com.example.arogyanidhiai1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionScreen(
    language: String,
    onFinish: (Boolean) -> Unit
) {

    var age by remember {
        mutableStateOf("")
    }

    var gender by remember {
        mutableStateOf("")
    }

    var income by remember {
        mutableStateOf("")
    }

    var bpl by remember {
        mutableStateOf("")
    }

    var occupation by remember {
        mutableStateOf("")
    }

    val isKannada = language == "Kannada"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Text(
            text =
                if (isKannada)
                    "ಅರ್ಹತಾ ಪ್ರಶ್ನಾವಳಿ"
                else
                    "Eligibility Questionnaire",

            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // AGE

        Text(
            text =
                if (isKannada)
                    "1. ನಿಮ್ಮ ವಯಸ್ಸನ್ನು ನಮೂದಿಸಿ"
                else
                    "1. Enter your age"
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = age,

            onValueChange = {
                age = it
            },

            label = {

                Text(
                    if (isKannada)
                        "ವಯಸ್ಸು"
                    else
                        "Age"
                )
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // GENDER

        Text(
            text =
                if (isKannada)
                    "2. ಲಿಂಗ ಆಯ್ಕೆಮಾಡಿ"
                else
                    "2. Select Gender"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {

            RadioButton(
                selected = gender == "Male",

                onClick = {
                    gender = "Male"
                }
            )

            Text(
                if (isKannada)
                    "ಪುರುಷ"
                else
                    "Male"
            )
        }

        Row {

            RadioButton(
                selected = gender == "Female",

                onClick = {
                    gender = "Female"
                }
            )

            Text(
                if (isKannada)
                    "ಮಹಿಳೆ"
                else
                    "Female"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // INCOME

        Text(
            text =
                if (isKannada)
                    "3. ನಿಮ್ಮ ಆದಾಯ ಮಟ್ಟ ಏನು?"
                else
                    "3. What is your income level?"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {

            RadioButton(
                selected = income == "LOW",

                onClick = {
                    income = "LOW"
                }
            )

            Text(
                if (isKannada)
                    "ಕಡಿಮೆ"
                else
                    "Low"
            )
        }

        Row {

            RadioButton(
                selected = income == "MEDIUM",

                onClick = {
                    income = "MEDIUM"
                }
            )

            Text(
                if (isKannada)
                    "ಮಧ್ಯಮ"
                else
                    "Medium"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // BPL

        Text(
            text =
                if (isKannada)
                    "4. ನಿಮ್ಮ ಬಳಿ BPL ಕಾರ್ಡ್ ಇದೆಯೆ?"
                else
                    "4. Do you have BPL card?"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {

            RadioButton(
                selected = bpl == "YES",

                onClick = {
                    bpl = "YES"
                }
            )

            Text(
                if (isKannada)
                    "ಹೌದು"
                else
                    "Yes"
            )
        }

        Row {

            RadioButton(
                selected = bpl == "NO",

                onClick = {
                    bpl = "NO"
                }
            )

            Text(
                if (isKannada)
                    "ಇಲ್ಲ"
                else
                    "No"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // OCCUPATION

        Text(
            text =
                if (isKannada)
                    "5. ಉದ್ಯೋಗ ಆಯ್ಕೆಮಾಡಿ"
                else
                    "5. Select Occupation"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {

            RadioButton(
                selected = occupation == "Farmer",

                onClick = {
                    occupation = "Farmer"
                }
            )

            Text(
                if (isKannada)
                    "ರೈತ"
                else
                    "Farmer"
            )
        }

        Row {

            RadioButton(
                selected = occupation == "Labour",

                onClick = {
                    occupation = "Labour"
                }
            )

            Text(
                if (isKannada)
                    "ಕಾರ್ಮಿಕ"
                else
                    "Labour"
            )
        }

        Row {

            RadioButton(
                selected = occupation == "Student",

                onClick = {
                    occupation = "Student"
                }
            )

            Text(
                if (isKannada)
                    "ವಿದ್ಯಾರ್ಥಿ"
                else
                    "Student"
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = {

                val ageNumber =
                    age.toIntOrNull() ?: 0

                val isEligible =
                    income == "LOW" &&
                            bpl == "YES" &&
                            ageNumber >= 18

                onFinish(isEligible)
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text =
                    if (isKannada)
                        "ಫಲಿತಾಂಶ ನೋಡಿ"
                    else
                        "Submit & See Results"
            )
        }
    }
}