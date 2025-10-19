package com.shreekrishna.composecomponets.LightButton

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiscordLightButton() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        val isHovered by interactionSource.collectIsHoveredAsState()

        val isActive = isPressed || isHovered

        val discordColor = Color(0xFF5865F2)
        val backgroundColor = Color(0xFF0A0A0A)
        val defaultColor = Color(0xFF0F0F0F)

        val animatedColor by animateColorAsState(
            targetValue = if (isActive) discordColor else defaultColor, animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
            ), label = "color"
        )

        val animatedOutlineOffset by animateDpAsState(
            targetValue = if (isActive) 2.dp else 20.dp, animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
            ), label = "offset"
        )

        val lightIntensity by animateFloatAsState(
            targetValue = if (isActive) 1f else 0f, animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium
            ), label = "light"
        )

        val buttonScale by animateFloatAsState(
            targetValue = if (isActive) 1.05f else 1f, animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
            ), label = "scale"
        )

        Box(
            modifier = Modifier
                .height(200.dp)
                .width(270.dp)
                .clickable(
                    interactionSource = interactionSource, indication = null
                ) { }) {
            Canvas(
                modifier = Modifier
                    .width(1000.dp)
                    .height(200.dp)
                    .align(Alignment.TopCenter)
            ) {
                val path = Path().apply {
                    moveTo(size.width / 2, 0f)
                    lineTo(size.width * 0.15f, size.height)
                    lineTo(size.width * 0.85f, size.height)
                    close()
                }

                if (lightIntensity > 0f) {
                    val brush = Brush.verticalGradient(
                        colors = listOf(
                            discordColor.copy(alpha = 0.8f * lightIntensity),
                            discordColor.copy(alpha = 0.4f * lightIntensity),
                            discordColor.copy(alpha = 0.1f * lightIntensity),
                            Color.White.copy(alpha = 0f)
                        ), startY = 0f, endY = size.height * 0.8f
                    )

                    drawPath(
                        path = path, brush = brush, style = Fill
                    )
                }
            }

            // Dot at top - Above everything
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(backgroundColor)
                    .align(Alignment.TopCenter)
            )

            Box(
                modifier = Modifier
                    .size((100 * buttonScale).dp)
                    .align(Alignment.BottomCenter)
                    .background(backgroundColor, RoundedCornerShape(5.dp))
                    .border(
                        width = 2.dp, color = animatedColor, shape = RoundedCornerShape(5.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Canvas(modifier = Modifier.size(50.dp)) {
                        val paint = Paint().asFrameworkPaint().apply {
                            isAntiAlias = true
                            color = animatedColor.toArgb()
                        }

                        val scaleFactor = size.width / 24f

                        drawContext.canvas.nativeCanvas.apply {
                            save()
                            scale(scaleFactor, scaleFactor)

                            val path = android.graphics.Path().apply {
                                moveTo(20.317f, 4.3698f)
                                cubicTo(18.7873f, 3.7892f, 17.1851f, 3.3498f, 15.5319f, 2.8546f)
                                cubicTo(15.5056f, 2.8491f, 15.4789f, 2.8621f, 15.4653f, 2.8854f)
                                cubicTo(15.2543f, 3.2607f, 15.0206f, 3.7502f, 14.857f, 4.1349f)
                                cubicTo(13.0123f, 3.8587f, 11.177f, 3.8587f, 9.3702f, 4.1349f)
                                cubicTo(9.2066f, 3.7416f, 8.9644f, 3.2607f, 8.7525f, 2.8854f)
                                cubicTo(8.7389f, 2.8629f, 8.7122f, 2.8499f, 8.686f, 2.8546f)
                                cubicTo(7.0336f, 3.3481f, 5.4314f, 3.7875f, 3.9008f, 4.3698f)
                                cubicTo(3.8887f, 4.3746f, 3.8781f, 4.383f, 3.8708f, 4.3952f)
                                cubicTo(0.5334f, 9.0458f, -0.319f, 13.5799f, 0.0992f, 18.0578f)
                                cubicTo(0.1008f, 18.0751f, 0.1102f, 18.0916f, 0.1237f, 18.1024f)
                                cubicTo(2.1765f, 19.61f, 4.165f, 20.5252f, 6.1166f, 21.1318f)
                                cubicTo(6.1428f, 21.1396f, 6.1705f, 21.1294f, 6.1851f, 21.1075f)
                                cubicTo(6.6467f, 20.4771f, 7.0582f, 19.8123f, 7.4111f, 19.1133f)
                                cubicTo(7.4265f, 19.0827f, 7.4119f, 19.0468f, 7.3804f, 19.0351f)
                                cubicTo(6.7276f, 18.7875f, 6.1061f, 18.4856f, 5.5082f, 18.1428f)
                                cubicTo(5.4731f, 18.1216f, 5.4701f, 18.0717f, 5.5028f, 18.0468f)
                                cubicTo(5.6286f, 17.9525f, 7.7545f, 17.8545f, 5.8746f, 17.7554f)
                                cubicTo(5.8903f, 17.7422f, 5.9118f, 17.7391f, 5.9301f, 17.7475f)
                                cubicTo(9.8579f, 19.5408f, 14.1101f, 19.5408f, 17.9915f, 17.7475f)
                                cubicTo(18.0098f, 17.7383f, 18.0313f, 17.7414f, 18.0478f, 17.7546f)
                                cubicTo(18.168f, 17.8537f, 18.2938f, 17.9525f, 18.4206f, 18.0468f)
                                cubicTo(18.4533f, 18.0717f, 18.4511f, 18.1216f, 18.416f, 18.1428f)
                                cubicTo(17.818f, 18.4914f, 17.1965f, 18.7875f, 16.5429f, 19.0342f)
                                cubicTo(16.5114f, 19.0459f, 16.4976f, 19.0827f, 16.5122f, 19.1133f)
                                cubicTo(16.8726f, 19.8114f, 17.2841f, 20.4762f, 17.7372f, 21.1067f)
                                cubicTo(17.7511f, 21.1294f, 17.7796f, 21.1396f, 17.8058f, 21.1318f)
                                cubicTo(19.7669f, 20.5252f, 21.7553f, 19.61f, 23.8081f, 18.1024f)
                                cubicTo(23.8224f, 18.0916f, 23.831f, 18.0759f, 23.8326f, 18.0586f)
                                cubicTo(24.3328f, 12.8816f, 22.9944f, 8.4847f, 20.2841f, 4.3959f)
                                cubicTo(20.2776f, 4.383f, 20.267f, 4.3746f, 20.2549f, 4.3698f)
                                lineTo(20.317f, 4.3698f)
                                close()

                                moveTo(8.02f, 15.3312f)
                                cubicTo(6.8375f, 15.3312f, 5.8631f, 14.2455f, 5.8631f, 12.9122f)
                                cubicTo(5.8631f, 11.579f, 6.8186f, 10.4933f, 8.02f, 10.4933f)
                                cubicTo(9.2308f, 10.4933f, 10.1957f, 11.5885f, 10.1768f, 12.9122f)
                                cubicTo(10.1768f, 14.2455f, 9.2213f, 15.3312f, 8.02f, 15.3312f)
                                close()

                                moveTo(15.9948f, 15.3312f)
                                cubicTo(14.8123f, 15.3312f, 13.8379f, 14.2455f, 13.8379f, 12.9122f)
                                cubicTo(13.8379f, 11.579f, 14.7933f, 10.4933f, 15.9948f, 10.4933f)
                                cubicTo(17.2056f, 10.4933f, 18.1705f, 11.5885f, 18.1516f, 12.9122f)
                                cubicTo(18.1516f, 14.2455f, 17.2056f, 15.3312f, 15.9948f, 15.3312f)
                                close()
                            }

                            drawPath(path, paint)
                            restore()
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Discord",
                        color = animatedColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}