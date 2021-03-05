/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    MaterialTheme() {
        Surface(color = MaterialTheme.colors.background) {
            val totalTime = 60
            val countStarted = remember(calculation = { mutableStateOf(false) })
            val countState = remember(calculation = { mutableStateOf(60L) })
            val animatedProgress = remember { Animatable(countState.value / totalTime.toFloat()) }
            LaunchedEffect(countState.value) {
                Log.d("App", "Triggered! Current time:" + countState.value)
                Log.d("App", "Triggered! progress:" + countState.value / totalTime.toFloat())
                animatedProgress.animateTo(
                    targetValue = countState.value / totalTime.toFloat(),
                    animationSpec = tween(300)
                )
            }
            val timer = object : CountDownTimer(totalTime * 1000L, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    countState.value = millisUntilFinished / 1000
                    countStarted.value = true
                }

                override fun onFinish() {
                    countState.value = 0
                    countStarted.value = false
                }
            }
            Scaffold(
                content = {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Timer(
                            startColor = MaterialTheme.colors.secondary,
                            endColor = MaterialTheme.colors.primary,
                            disabledColor = MaterialTheme.colors.onBackground.copy(alpha = .1f),
                            progress = animatedProgress.value,
                            numberOfTicks = totalTime.toLong(),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .padding(56.dp)
                                .align(Alignment.TopCenter)
                        ) {
                            TimerText(text = DateUtils.formatElapsedTime(countState.value))
                        }
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 32.dp)
                        ) {
                            Button(
                                modifier = Modifier
                                    .padding(8.dp),
                                onClick = {
                                    timer.cancel()
                                    timer.start()
                                }
                            ) {
                                Text(text = "Start")
                            }

                            Button(
                                modifier = Modifier
                                    .padding(8.dp),
                                onClick = {
                                    timer.cancel()
                                }
                            ) {
                                Text(text = "Stop")
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun Timer(
    startColor: Color,
    endColor: Color,
    progress: Float,
    disabledColor: Color,
    numberOfTicks: Long,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.circleProgress(
            startColor,
            endColor,
            disabledColor,
            progress,
            numberOfTicks
        ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun TimerText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.onBackground
    )
}

private fun Modifier.circleProgress(
    startColor: Color,
    endColor: Color,
    disabledColor: Color,
    progress: Float,
    numberOfTicks: Long,
    strokeWidth: Dp = 4.dp
) = drawWithCache {
    // I would choose the way to calculate the color for each step (instead of using gradient)
    val brush = Brush.sweepGradient(
        0f to startColor,
        0.3f to startColor,
        0.99f to endColor,
        1f to startColor,
        center = size.center
    )

    // Math ... It works! Somehow...
    val circleSize = 360
    val stepSize = circleSize / numberOfTicks
    val centerX = size.width / 2f
    val centerY = size.height / 2f
    val centerOffset = size.width / 3
    val radius = min(size.center.x, size.center.y)

    val totalNumberOfTicks = circleSize / stepSize
    val numberOfTicksToShow = progress * totalNumberOfTicks

    onDrawBehind {
        rotate(-90f) {

            for (i in 0 until totalNumberOfTicks) {
                val currentAngle = i * stepSize

                val cos = cos(currentAngle * PI / 180)
                val sin = sin(currentAngle * PI / 180)

                val startX = cos * centerOffset
                val startY = sin * centerOffset

                val targetProgress = (numberOfTicksToShow - i).coerceIn(0f, 1f)
                val targetRadius = centerOffset + (radius - centerOffset) * targetProgress

                val targetX = cos * targetRadius
                val targetY = sin * targetRadius

                if (targetProgress < 1f) {
                    drawLine(
                        color = disabledColor,
                        start = Offset(centerX + startX.toFloat(), centerY + startY.toFloat()),
                        end = Offset(
                            centerX + (cos * radius).toFloat(),
                            centerY + (sin * radius).toFloat()
                        ),
                        cap = StrokeCap.Round,
                        strokeWidth = strokeWidth.toPx() / 2
                    )
                }

                if (targetProgress > 0f) {
                    drawLine(
                        brush = brush,
                        start = Offset(centerX + startX.toFloat(), centerY + startY.toFloat()),
                        end = Offset(centerX + targetX.toFloat(), centerY + targetY.toFloat()),
                        cap = StrokeCap.Round,
                        strokeWidth = strokeWidth.toPx()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp()
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
