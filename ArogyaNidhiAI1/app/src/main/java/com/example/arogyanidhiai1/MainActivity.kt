package com.example.arogyanidhiai1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.arogyanidhiai1.navigation.AppNavigation
import com.example.arogyanidhiai1.ui.theme.ArogyaNidhiAI1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ArogyaNidhiAI1Theme {

                AppNavigation()

            }
        }
    }
}