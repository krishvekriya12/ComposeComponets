package com.shreekrishna.composecomponets.Custom_Buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Gradient Button Component
 *
 * A customizable button with gradient background colors.
 *
 * @param text Button text to display
 * @param onClick Click callback function
 * @param modifier Modifier for customization
 * @param gradient Gradient brush for background
 * @param contentPadding Internal padding
 * @param enabled Button enabled state
 */
@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    gradient: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF6366F1),
            Color(0xFF8B5CF6)
        )
    ),
    contentPadding: PaddingValues = PaddingValues(
        horizontal = 32.dp,
        vertical = 16.dp
    ),
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = if (enabled) gradient else Brush.horizontalGradient(
                    colors = listOf(Color.Gray, Color.Gray)
                )
            )
            .clickable(enabled = enabled) { onClick() }
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
