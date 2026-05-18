package com.example.arogyanidhiai1.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arogyanidhiai1.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(onTimeout = {
                navController.navigate("language") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }

        composable("language") {
            LanguageScreen(onLanguageSelected = { language ->
                navController.navigate("home/$language")
            })
        }

        composable(
            route = "home/{language}",
            arguments = listOf(navArgument("language") { type = NavType.StringType })
        ) { backStackEntry ->
            val language = backStackEntry.arguments?.getString("language") ?: "English"
            HomeScreen(onStartClick = {
                navController.navigate("question/$language")
            })
        }

        composable(
            route = "question/{language}",
            arguments = listOf(navArgument("language") { type = NavType.StringType })
        ) { backStackEntry ->
            val language = backStackEntry.arguments?.getString("language") ?: "English"
            QuestionScreen(
                language = language,
                onFinish = { isEligible ->
                    navController.navigate("result/$isEligible")
                }
            )
        }

        composable(
            route = "result/{isEligible}",
            arguments = listOf(navArgument("isEligible") { type = NavType.BoolType })
        ) { backStackEntry ->
            val isEligible = backStackEntry.arguments?.getBoolean("isEligible") ?: false
            ResultScreen(
                isEligible = isEligible,
                onViewDocuments = { navController.navigate("document") },
                onFindHospitals = { navController.navigate("hospital") }
            )
        }

        composable("document") {
            DocumentScreen(onBack = { navController.popBackStack() })
        }

        composable("hospital") {
            HospitalScreen(onBack = { navController.popBackStack() })
        }
    }
}