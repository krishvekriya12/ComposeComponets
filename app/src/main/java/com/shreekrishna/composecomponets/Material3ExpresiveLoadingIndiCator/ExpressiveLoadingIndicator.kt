package com.shreekrishna.composecomponets.Material3ExpresiveLoadingIndiCator

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.WavyProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ExpressiveLoadingIndicator() {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F0C29), Color(0xFF302B63), Color(0xFF24243E)
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            AnimatedHeader()

            GlassCard(
                title = "🎭 Morphing Shapes", subtitle = "Dynamic polygon transformations"
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PremiumIndicatorBox(
                            label = "Mystic Ghost",
                            color1 = Color(0xFF667EEA),
                            color2 = Color(0xFF764BA2),
                            modifier = Modifier.weight(1f)
                        ) {
                            LoadingIndicator(
                                modifier = Modifier.size(85.dp),
                                color = Color(0xFF667EEA),
                                polygons = listOf(
                                    MaterialShapes.Ghostish, MaterialShapes.Diamond
                                )
                            )
                        }

                        PremiumIndicatorBox(
                            label = "Elegant Arch",
                            color1 = Color(0xFF06BEB6),
                            color2 = Color(0xFF48B1BF),
                            modifier = Modifier.weight(1f)
                        ) {
                            LoadingIndicator(
                                modifier = Modifier.size(85.dp),
                                color = Color(0xFF06BEB6),
                                polygons = listOf(
                                    MaterialShapes.Arch, MaterialShapes.Cookie6Sided
                                )
                            )
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PremiumIndicatorBox(
                            label = "Swift Arrow",
                            color1 = Color(0xFFFF6B9D),
                            color2 = Color(0xFFC06C84),
                            modifier = Modifier.weight(1f)
                        ) {
                            LoadingIndicator(
                                modifier = Modifier.size(85.dp),
                                color = Color(0xFFFF6B9D),
                                polygons = listOf(
                                    MaterialShapes.Arrow, MaterialShapes.Pentagon
                                )
                            )
                        }

                        PremiumIndicatorBox(
                            label = "Solar Burst",
                            color1 = Color(0xFFFFA726),
                            color2 = Color(0xFFFFD54F),
                            modifier = Modifier.weight(1f)
                        ) {
                            LoadingIndicator(
                                modifier = Modifier.size(85.dp),
                                color = Color(0xFFFFA726),
                                polygons = listOf(
                                    MaterialShapes.Boom, MaterialShapes.Cookie6Sided
                                )
                            )
                        }
                    }
                }
            }

            GlassCard(
                title = "✨ Contained Brilliance", subtitle = "Enclosed radiant animations"
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PremiumIndicatorBox(
                        label = "Golden Boom",
                        color1 = Color(0xFFFFD700),
                        color2 = Color(0xFFFFB800),
                        modifier = Modifier.weight(1f)
                    ) {
                        ContainedLoadingIndicator(
                            modifier = Modifier.size(85.dp),
                            containerColor = Color(0xFF2A2A2A),
                            indicatorColor = Color(0xFFFFD700),
                            polygons = listOf(
                                MaterialShapes.Boom, MaterialShapes.Diamond
                            )
                        )
                    }

                    PremiumIndicatorBox(
                        label = "Emerald Pulse",
                        color1 = Color(0xFF00E676),
                        color2 = Color(0xFF00C853),
                        modifier = Modifier.weight(1f)
                    ) {
                        ContainedLoadingIndicator(
                            modifier = Modifier.size(85.dp),
                            containerColor = Color(0xFF1A1A1A),
                            indicatorColor = Color(0xFF00E676),
                            polygons = LoadingIndicatorDefaults.IndeterminateIndicatorPolygons
                        )
                    }
                }
            }

            GlassCard(
                title = "🌊 Wave Motion", subtitle = "Flowing liquid animations"
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(28.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PremiumIndicatorBox(
                        label = "Orbital Wave",
                        color1 = Color(0xFF667EEA),
                        color2 = Color(0xFF764BA2),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CircularWavyProgressIndicator(
                            modifier = Modifier.size(105.dp),
                            color = Color(0xFF667EEA),
                            trackColor = Color(0xFF2D3561),
                            stroke = WavyProgressIndicatorDefaults.circularTrackStroke,
                            trackStroke = WavyProgressIndicatorDefaults.linearIndicatorStroke,
                            gapSize = WavyProgressIndicatorDefaults.LinearDeterminateWavelength
                        )
                    }

                    PremiumIndicatorBox(
                        label = "Flowing Stream",
                        color1 = Color(0xFF06BEB6),
                        color2 = Color(0xFF48B1BF),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        LinearWavyProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(12.dp),
                            color = Color(0xFF06BEB6),
                            trackColor = Color(0xFF2D4A5A)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun AnimatedHeader() {
    val infiniteTransition = rememberInfiniteTransition(label = "header")

    val scale by infiniteTransition.animateFloat(
        initialValue = 0.98f, targetValue = 1.02f, animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = FastOutSlowInEasing), repeatMode = RepeatMode.Reverse
        ), label = "scale"
    )

    val shimmer by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing), repeatMode = RepeatMode.Restart
        ), label = "shimmer"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .scale(scale)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "MATERIAL 3",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF667EEA).copy(alpha = 0.7f + shimmer * 0.3f),
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 4.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Expressive Loading",
            style = MaterialTheme.typography.displayMedium,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.5.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "✦",
                color = Color(0xFFFFD700).copy(alpha = 0.6f + shimmer * 0.4f),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Premium Collection",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFFFD700),
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.5.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "✦",
                color = Color(0xFFFFD700).copy(alpha = 0.6f + shimmer * 0.4f),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun GlassCard(
    title: String, subtitle: String, content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.12f), Color.White.copy(alpha = 0.06f)
                    )
                )
            )
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.6f),
                fontWeight = FontWeight.Normal
            )
        }
        content()
    }
}

@Composable
private fun PremiumIndicatorBox(
    label: String,
    color1: Color,
    color2: Color,
    modifier: Modifier = Modifier,
    indicator: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = label)

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.25f, targetValue = 0.55f, animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = EaseInOutCubic), repeatMode = RepeatMode.Reverse
        ), label = "alpha"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        color1.copy(alpha = alpha * 0.25f), color2.copy(alpha = alpha * 0.25f)
                    )
                )
            )
            .padding(vertical = 24.dp, horizontal = 16.dp)
    ) {
        indicator()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = Color.White.copy(alpha = 0.95f),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            letterSpacing = 0.5.sp
        )
    }
}