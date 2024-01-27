/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.someoldjokes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AirplaneTicket
import androidx.compose.material.icons.outlined.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.wear.compose.foundation.lazy.itemsIndexed
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.InlineSlider
import androidx.wear.compose.material.InlineSliderDefaults
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Stepper
import androidx.wear.compose.material.StepperDefaults
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.TimeTextDefaults
import androidx.wear.compose.material.ToggleChip
import androidx.wear.compose.material.ToggleChipDefaults
import androidx.wear.compose.material.dialog.Alert
import com.example.someoldjokes.R
import com.example.someoldjokes.presentation.mvvm.ListViewModel
import com.example.someoldjokes.presentation.theme.SomeOldJokesTheme
import java.text.DateFormat

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        setContent {
            SomeOldJokesTheme {
                listExample(viewModel)
            }
        }
    }
}

@Composable
fun WearApp(greetingName: String) {
    SomeOldJokesTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */

        // List()
        // ButtonExample()
        //ChipExample()
        // ToggleChipExample()
        //  SliderExample()
        //  StepperExample()
        //  CardExample()
        //  CircularProgressIndicatorExample()
        // DialogExample()
        //listExample()
        //  TimeTextExample()


    }
}

@Composable
fun TimeTextExample() {
    TimeText(
        timeSource = TimeTextDefaults.timeSource(
            DateFormat.getAvailableLocales().toString()
        )
    )

}

@Composable
fun List() {

    val list: List<String> = listOf(
        "India",
        "Karun",
        "Priya",
        "Moma",
        "Delhi",
        "Bangalore",
        "Pune",
        "Karun",
        "Priya",
        "Moma",
        "Delhi",
        "Bangalore",
        "Pune"
    )
    LazyColumn() {
        items(list) {
            Chip(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                label = { Text("$it") },
                onClick = { },
                secondaryLabel = { Text("Secondary label") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "call",
                    )
                }
            )
        }
    }
}

@Composable
fun ButtonExample() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "call",
            )
        }
    }
}

@Composable
fun ChipExample() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Chip(
            onClick = { },
            enabled = true,
            label = {
                Text(
                    text = "Karun",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            secondaryLabel = {
                Text(text = "Call", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            icon = {
                Icon(
                    Icons.Outlined.Call,
                    contentDescription = "call",
                    modifier = Modifier
                        .size(ChipDefaults.IconSize)
                        .wrapContentSize(align = Alignment.Center),
                )
            }, colors = ChipDefaults.imageBackgroundChipColors(
                backgroundImagePainter = painterResource(id = R.drawable.icon_pp)
            )
        )


    }

}

@Composable
fun ToggleChipExample() {
    var checked by remember { mutableStateOf(true) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToggleChip(
            label = {
                Text("Karun!", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            secondaryLabel = {
                Text("Compose Wear OS!", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            checked = checked,
            colors = ToggleChipDefaults.toggleChipColors(
                uncheckedToggleControlColor = ToggleChipDefaults.SwitchUncheckedIconColor
            ),
            toggleControl = {
                Switch(
                    checked = checked,
                    enabled = true,
                    modifier = Modifier.semantics {
                        this.contentDescription =
                            if (checked) "On" else "Off"
                    }
                )
            },
            onCheckedChange = { checked = it },
            appIcon = {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = "call",
                    modifier = Modifier
                        .size(24.dp)
                        .wrapContentSize(align = Alignment.Center),
                )
            },
            enabled = true,
        )
    }

}

@Composable
fun SliderExample() {
    var value by remember { mutableStateOf(4.5f) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        InlineSlider(
            value = value,
            onValueChange = { value = it },
            increaseIcon = { Icon(InlineSliderDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(InlineSliderDefaults.Decrease, "Decrease") },
            valueRange = 3f..6f,
            steps = 5,
            segmented = true
        )

    }

}

@Composable
fun StepperExample() {
    var value by remember { mutableStateOf(5) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Stepper(
            value = value,
            onValueChange = { value = it },
            increaseIcon = { Icon(StepperDefaults.Increase, "Increase") },
            decreaseIcon = { Icon(StepperDefaults.Decrease, "Decrease") },
            valueProgression = 0..10
        ) { Text("Value: $value") }


    }
}

@Composable
fun CardExample() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Card(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            contentColor = Color.Yellow,
            shape = RoundedCornerShape(20.dp),
        ) {


            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.priya),
                    contentDescription = "",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(100.dp)
                )
                Text("Karun ", textAlign = TextAlign.Center)
            }

        }

    }
}

@Composable
fun CircularProgressIndicatorExample() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 1.dp),
        startAngle = 295.5f,
        endAngle = 245.5f,
        progress = 0.3f,
        strokeWidth = 5.dp,
        indicatorColor = Color.Green,
        trackColor = Color.LightGray
    )
}


@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScalingLazyListState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(
            onClick = { showDialog = true },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
        ) {


            Icon(
                Icons.Outlined.AirplaneTicket,
                contentDescription = "",
            )


        }


        androidx.wear.compose.material.dialog.Dialog(
            showDialog = showDialog,
            onDismissRequest = { showDialog = false }, scrollState = scrollState
        ) {

            Alert(
                scrollState = scrollState,
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                contentPadding =
                PaddingValues(start = 10.dp, end = 10.dp, top = 24.dp, bottom = 52.dp),
                icon = {
                    Icon(
                        Icons.Outlined.Call,
                        contentDescription = "airplane",
                        modifier = Modifier
                            .size(24.dp)
                            .wrapContentSize(align = Alignment.Center)
                            .clickable { showDialog = false },

                        )
                },
                title = { Text(text = "Example Title Text", textAlign = TextAlign.Center) },
                message = {
                    Text(
                        text = "Message content goes here",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body2
                    )
                },
            ) {
                item {
                    Chip(
                        label = { Text("Primary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.primaryChipColors(),
                    )
                }
                item {
                    Chip(
                        label = { Text("Secondary") },
                        onClick = { showDialog = false },
                        colors = ChipDefaults.secondaryChipColors(),
                    )
                }


            }
        }


        //For Dialog Animation
        /*
        androidx.wear.compose.material.dialog.Dialog(showDialog = showDialog, onDismissRequest = { showDialog = false }) {
            val animation = AnimatedImageVector.animatedVectorResource(R.drawable.denis)
            Confirmation(
                onTimeout = { showDialog = false },
                icon = {
                    // Initially, animation is static and shown at the start position (atEnd = false).
                    // Then, we use the EffectAPI to trigger a state change to atEnd = true,
                    // which plays the animation from start to end.
                    var atEnd by remember { mutableStateOf(false) }
                    DisposableEffect(Unit) {
                        atEnd = true
                        onDispose {}
                    }
                    Image(
                        painter = rememberAnimatedVectorPainter(animation, atEnd),
                        contentDescription = "Open on phone",
                        modifier = Modifier.size(48.dp)
                    )
                },
                durationMillis = 3000,
            ) {
                Text(text = "Open on phone", textAlign = TextAlign.Center)
            }
        }
         */


    }
}


@Composable
fun listExample(viewModel: ListViewModel) {
    val listNews by viewModel.listNews.collectAsState(emptyList())
    val isLoading by viewModel.isLoading.collectAsState(false)
    val listState = rememberScalingLazyListState()

    LaunchedEffect(Unit) {
        viewModel.getList()
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.fillMaxSize()) {
            androidx.wear.compose.foundation.lazy.ScalingLazyColumn(state = listState) {
                itemsIndexed(items = listNews) { index, item ->
                    Card(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        contentColor = Color.Black,
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Row {
                           Image(
                               painter = painterResource(id = R.drawable.ka),
                               contentScale = ContentScale.FillBounds,
                               modifier = Modifier.size(50.dp)
                               , contentDescription ="" )
                            Column(
                                Modifier
                                    .padding(start = 5.dp)
                                    .fillMaxSize(),
                            ) {
                                Text(
                                    item.title ?: "",
                                    color = Color.Yellow,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Start,
                                    fontSize = 10.sp
                                )
                                Text(
                                    item.description ?: "",
                                    fontSize = 8.sp,
                                    maxLines = 2,
                                    color = Color.LightGray,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }
                        }
                    }


                }
            }
        }
        LoadingProgress(isLoading)
    }
}

@Composable
fun LoadingProgress(
    showDialog: Boolean,
) {
    if (showDialog) {
        Box(Modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp)
            )
        }
    }
}