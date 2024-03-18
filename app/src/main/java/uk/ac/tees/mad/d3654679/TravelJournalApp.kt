package uk.ac.tees.mad.d3654679

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.d3654679.screens.HomeScreen
import uk.ac.tees.mad.d3654679.screens.HomeScreenDestination
import uk.ac.tees.mad.d3654679.screens.SplashDestination
import uk.ac.tees.mad.d3654679.screens.SplashScreen

@Composable
fun TravelJournalApp() {
    // Create a NavHostController to manage navigation within the app
    val navController = rememberNavController()

    // Define the navigation graph using NavHost
    NavHost(navController = navController, startDestination = SplashDestination.route) {
        // Splash screen destination
        composable(SplashDestination.route) {
            // Display the splash screen composable
            SplashScreen(navController = navController)
        }
        // Home screen destination
        composable(HomeScreenDestination.route) {
            // Display the home screen composable
            HomeScreen(navController = navController)
        }
    }
}

interface NavigationDestination {
    val route: String
    val titleRes: Int
}
