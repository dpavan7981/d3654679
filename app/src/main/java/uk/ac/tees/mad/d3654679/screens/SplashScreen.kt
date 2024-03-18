package uk.ac.tees.mad.d3654679.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uk.ac.tees.mad.d3654679.NavigationDestination
import uk.ac.tees.mad.d3654679.R

object SplashDestination : NavigationDestination {
    override val route: String
        get() = "splash" // Route name for the splash destination
    override val titleRes: Int
        get() = R.string.app_name // Title resource for the splash screen
}

@Composable
fun SplashScreen(navController: NavHostController) {
    // Animation duration using Animatable
    val animTime = remember {
        Animatable(0f)
    }


    // Launch effect for animation and navigation
    LaunchedEffect(key1 = true) {
        animTime.animateTo(
            1f,
            animationSpec = tween(2000)
        ) // Animation to scale the splash screen elements

        delay(500L) // Delay before navigating to the next screen
        launch(Dispatchers.Main) {
            navController.popBackStack() // Clear any existing back stack
            navController.navigate(HomeScreenDestination.route) // Navigate to the home screen
        }
    }

    // Column layout for the splash screen content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Background color for the splash screen
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box {
            Image(
                painter = painterResource(id = R.drawable.travel_diary), // Your splash image resource
                contentDescription = "Splash Screen",
                modifier = Modifier
                    .size(200.dp)
                    .scale(animTime.value)
                    .graphicsLayer(alpha = animTime.value)
            )
        }
        Spacer(modifier = Modifier.height(30.dp)) // Spacer for layout
        // App name text
        Text(
            text = "Travel Journal",
            fontSize = 32.sp, // Font size
            fontWeight = FontWeight.Bold, // Font weight
            color = Color.Black, // Text color
            modifier = Modifier
                .alpha(animTime.value)
                .scale(animTime.value) // Alpha and scale animation for text
        )

        Spacer(modifier = Modifier.height(5.dp)) // Spacer for layout

        // Subtitle text
        Text(
            text = "Keep your good memories.",
            fontSize = 18.sp, // Font size
            fontWeight = FontWeight.Bold, // Font weight
            color = Color.Black, // Text color
            modifier = Modifier.alpha(animTime.value) // Alpha animation for text
        )
    }


}
