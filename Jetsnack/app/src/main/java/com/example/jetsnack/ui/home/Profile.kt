/*
 * Copyright 2020 The Android Open Source Project
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

package com.example.jetsnack.ui.home

import android.content.res.Configuration
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetsnack.R
import com.example.jetsnack.ui.theme.JetsnackTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun Profile(modifier: Modifier = Modifier) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier
//            .fillMaxSize()
//            .wrapContentSize()
//            .padding(24.dp)
//    ) {
//        Image(
//            painterResource(R.drawable.empty_state_search),
//            contentDescription = null
//        )
//        Spacer(Modifier.height(24.dp))
//        Text(
//            text = stringResource(R.string.work_in_progress),
//            style = MaterialTheme.typography.subtitle1,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(Modifier.height(16.dp))
//        Text(
//            text = stringResource(R.string.grab_beverage),
//            style = MaterialTheme.typography.body2,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
    Box(modifier.fillMaxSize()) {
        val appBarHeight = 60.dp
        var height by remember {
            mutableStateOf(0f)
        }
        val density = LocalDensity.current
        val animatedHeight by animateDpAsState(targetValue = with(density){height.toDp()})


        val gradient = remember {
            // #8F8CFF 0%, #1F33E4 40.83%, #002994 81.77%
            Brush.linearGradient(
                0f to Color(0xFF8F8CFF), 0.4083f to Color(0xFF1F33E4), 0.8177f to Color(0xFF002994),
//                        listOf(0f, 0.4083f, 0.8177f),
//                        angleInDegrees = 135f,
//                        useAsCssAngle = true
                start = Offset(77.5f, -77.5f),
                end = Offset(1002.5f, 847.5f)
            )
            // linear-gradient(155.25deg, #0803FF49 -17.34%, #1F33E4 45.02%, #002994 71.39%, #012175 88.28%);
//                    LinearGradient(
//                        listOf(Color(0x4D1F33E4), Color(0xFF1F33E4), Color(0xFF002994), Color(0xFF012175)),
//                        listOf(0f, 0.45f, 0.7139f, 0.8827f),
//                        angleInDegrees = 135f,
//                        useAsCssAngle = true
//                    )
        }
        Spacer(
            modifier = Modifier
                .height(280.dp)
//                .height(animatedHeight)
                .fillMaxWidth()
                .shadow(if (animatedHeight == appBarHeight) 8.dp else 0.dp)
//                .aspectRatio()
//                .background(Color.White)
                .background(gradient)
        )

        Column(modifier = Modifier
            .fillMaxSize()
//            .statusBarsPadding()
        ){

//            TopAppBar(modifier = Modifier
////                .background(Brush.horizontalGradient(JetsnackTheme.colors.tornado1))
//                .height(height = animatedHeight),
//                elevation = /*if (animatedHeight == appBarHeight) 6.dp else 0.dp*/ 6.dp,
//                backgroundColor = Color.Red
//            ){}

            Box(
                modifier = Modifier
                    .height(appBarHeight + with(density) {
                        WindowInsets.statusBars
                            .getTop(density)
                            .toDp()
                    })
//                .height(animatedHeight)
                    .fillMaxWidth()
                    .shadow(if (animatedHeight == appBarHeight) 0.dp else 8.dp)
                    .background(Color.White)
                    .background(gradient)
                    .statusBarsPadding()
            ) {
                Text("Balance here", modifier = Modifier.align(Alignment.BottomCenter).padding(8.dp))
            }

            SwipeRefresh(
                state = rememberSwipeRefreshState(false),
                indicatorPadding = PaddingValues(
                    top = 280.dp - with(density){WindowInsets.statusBars.getTop(density).toDp()} - appBarHeight
                ),
                onRefresh = {}
            ) {
                LazyScrollView(onOffsetChanged = {
                    Log.d("OFFSET", "$it")
                    height = it
                }, appBarHeight = appBarHeight)
            }
        }
    }
}

// https://medium.com/@bimurat.mukhtar/how-to-implement-linear-gradient-with-any-angle-in-jetpack-compose-3ded798c81f5
@Immutable
class LinearGradientCSS constructor(
    private val colors: List<Color>,
    private val stops: List<Float>? = null,
    private val tileMode: TileMode = TileMode.Clamp,
    angleInDegrees: Float = 0f,
    useAsCssAngle: Boolean = false
) : ShaderBrush() {

    // handle edge cases like: -1235, ...
    private val normalizedAngle: Float = if (useAsCssAngle) {
        ((90 - angleInDegrees) % 360 + 360) % 360
    } else {
        (angleInDegrees % 360 + 360) % 360
    }
    private val angleInRadians: Float = Math.toRadians(normalizedAngle.toDouble()).toFloat()

    override fun createShader(size: Size): Shader {
        val (from, to) = getGradientCoordinates(size = size)
        Log.d("SHADER","$from $to")

        return LinearGradientShader(
            colors = colors,
            colorStops = stops,
            from = from,
            to = to,
            tileMode = tileMode
        )
    }

    private fun getGradientCoordinates(size: Size): Pair<Offset, Offset> {
        val diagonal = sqrt(size.width.pow(2) + size.height.pow(2))
        val angleBetweenDiagonalAndWidth = acos(size.width / diagonal)
        val angleBetweenDiagonalAndGradientLine =
            if ((normalizedAngle > 90 && normalizedAngle < 180)
                || (normalizedAngle > 270 && normalizedAngle < 360)
            ) {
                PI.toFloat() - angleInRadians - angleBetweenDiagonalAndWidth
            } else {
                angleInRadians - angleBetweenDiagonalAndWidth
            }
        val halfGradientLine = abs(cos(angleBetweenDiagonalAndGradientLine) * diagonal) / 2

        val horizontalOffset = halfGradientLine * cos(angleInRadians)
        val verticalOffset = halfGradientLine * sin(angleInRadians)

        val start = size.center + Offset(-horizontalOffset, verticalOffset)
        val end = size.center + Offset(horizontalOffset, -verticalOffset)

        return start to end
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LinearGradientCSS) return false

        if (colors != other.colors) return false
        if (stops != other.stops) return false
        if (normalizedAngle != other.normalizedAngle) return false
        if (tileMode != other.tileMode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = colors.hashCode()
        result = 31 * result + (stops?.hashCode() ?: 0)
        result = 31 * result + normalizedAngle.hashCode()
        result = 31 * result + tileMode.hashCode()
        return result
    }

    override fun toString(): String {
        return "LinearGradient(colors=$colors, " +
                "stops=$stops, " +
                "angle=$normalizedAngle, " +
                "tileMode=$tileMode)"
    }
}

@Composable
fun LazyScrollView(onOffsetChanged: (Float) -> Unit, appBarHeight: Dp){
    val pixelValue = with(LocalDensity.current){appBarHeight.toPx()}
    val nestedScrollState = rememberNestedScrollConnection(onOffsetChanged = onOffsetChanged, appBarHeight = pixelValue)
    LaunchedEffect(key1 = Unit, block = {
        onOffsetChanged(pixelValue)
    })
    Box(modifier = Modifier
        .fillMaxSize()
//        .background(Color.Blue)
        .nestedScroll(nestedScrollState)){

//        AndroidView(factory = { context ->
//            RecyclerView(context).apply {
//                adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
//                    override fun onCreateViewHolder(
//                        parent: ViewGroup,
//                        viewType: Int
//                    ): RecyclerView.ViewHolder {
//                        val textView = TextView(parent.context).apply {
//                            setPadding((8 * context.resources.displayMetrics.density).toInt())
//                        }
//                        return object : RecyclerView.ViewHolder(textView) {}
//                    }
//
//                    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//                        (holder.itemView as TextView).text = position.toString()
//                    }
//
//                    override fun getItemCount(): Int = 100
//                }
//                layoutManager = LinearLayoutManager(context)
//            }
//        }, modifier = Modifier.fillMaxSize())

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(count = 100){index ->
                Text(text = "$pixelValue; Some $index", modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(8.dp), color = MaterialTheme.colors.onBackground)
            }
        }
    }

}

fun Offset.roundToIntOffset(): IntOffset {
    return IntOffset(x = this.x.roundToInt(),y = this.y.roundToInt())
}

@Composable
fun rememberNestedScrollConnection(onOffsetChanged:(Float)->Unit,appBarHeight:Float) = remember {
    var currentHeight = appBarHeight
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            Log.d("AVAILABLE","$available")
            currentHeight = (currentHeight+available.y).coerceIn(minimumValue = 0f, maximumValue = appBarHeight)
            return if(abs(currentHeight) == appBarHeight || abs(currentHeight) == 0f){
                super.onPreScroll(available, source)
            }else{
                onOffsetChanged(currentHeight)
                available
            }
        }

        override suspend fun onPreFling(available: Velocity): Velocity {
            if(available.y<0){
                onOffsetChanged(0f)
            }else{
                onOffsetChanged(appBarHeight)
            }
            return super.onPreFling(available)
        }
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun ProfilePreview() {
    JetsnackTheme {
        Profile()
    }
}
