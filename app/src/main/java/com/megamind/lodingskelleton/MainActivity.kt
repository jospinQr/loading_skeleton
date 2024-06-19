package com.megamind.lodingskelleton

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.megamind.lodingskelleton.ui.theme.LodingSkelletonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LodingSkelletonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .padding(horizontal = 12.dp)
                    ) {
                        LazyRow {
                            items(4) {
                                SkeletonLoadingEffect(
                                    modifier = Modifier
                                        .height(80.dp)
                                        .width(80.dp)
                                        .clip(RoundedCornerShape(100))
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        LazyColumn {
                            items(8) {

                                SkeletonLoadingEffect(
                                    modifier = Modifier
                                        .fillParentMaxWidth()
                                        .height(250.dp)
                                        .clip(
                                            RoundedCornerShape(16.dp)
                                        )
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                SkeletonLoadingEffect(modifier = Modifier.fillParentMaxWidth().height(10.dp).clip(RoundedCornerShape(16.dp)))
                                Spacer(modifier = Modifier.height(4.dp))
                                SkeletonLoadingEffect(modifier = Modifier.width(270.dp).height(10.dp).clip(RoundedCornerShape(16.dp)))
                                Spacer(modifier = Modifier.height(4.dp))
                                SkeletonLoadingEffect(modifier = Modifier.width(200.dp).height(10.dp).clip(RoundedCornerShape(16.dp)))
                                Spacer(modifier = Modifier.height(4.dp))
                                SkeletonLoadingEffect(modifier = Modifier.width(180.dp).height(10.dp).clip(RoundedCornerShape(16.dp)))
                                Spacer(modifier = Modifier.height(14.dp))

                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SkeletonLoadingEffect(modifier: Modifier = Modifier) {
    val shimmerColors = listOf(
        Color.LightGray,
        MaterialTheme.colorScheme.background,
        Color.LightGray,

        )
    val shimmerAnimation = rememberInfiniteTransition(label = "")
    val translateAnim by shimmerAnimation.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1700, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim, y = translateAnim),
    )

    Box(
        modifier = modifier
            .background(brush)
    ) {
        // Votre contenu ici
    }
}



