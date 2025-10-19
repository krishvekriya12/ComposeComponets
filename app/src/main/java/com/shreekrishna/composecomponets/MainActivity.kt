package com.shreekrishna.composecomponets

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.shreekrishna.composecomponets.Custom_Buttons.GradientButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoScreen()
        }
    }
}

@Composable
fun DemoScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "🎨 Gradient Buttons",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        GradientButton(
            text = "Default Gradient", onClick = {
                Toast.makeText(context, "Default clicked!", Toast.LENGTH_SHORT).show()
            })

        GradientButton(
            text = "Warm Colors", onClick = {
                Toast.makeText(context, "Warm clicked!", Toast.LENGTH_SHORT).show()
            }, gradient = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFFF6B6B), Color(0xFFFFD93D)
                )
            )
        )

        GradientButton(
            text = "Nature Vibes", onClick = {
                Toast.makeText(context, "Nature clicked!", Toast.LENGTH_SHORT).show()
            }, gradient = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF11998E), Color(0xFF38EF7D)
                )
            )
        )

        GradientButton(
            text = "Sunset", onClick = {
                Toast.makeText(context, "Sunset clicked!", Toast.LENGTH_SHORT).show()
            }, gradient = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFFF6B9D), Color(0xFFFFA06B)
                )
            )
        )

        GradientButton(
            text = "Disabled State", onClick = { }, enabled = false
        )

        GradientButton(
            text = "Full Width Button", onClick = {
                Toast.makeText(context, "Full width clicked!", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier.fillMaxWidth()
        )
    }
}

