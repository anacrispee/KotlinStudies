@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.androidcourse_lemonade

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_lemonade.ui.theme.AndroidCourse_LemonadeTheme
import com.example.androidcourse_lemonade.ui.theme.blueIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourse_LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){
    var step by remember { mutableStateOf(1) }
    var counter by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = {
                Text(
                    text ="Lemonade",
                    fontWeight = FontWeight.Bold
                )
                    },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = colorResource(R.color.orangeApp)
            )
        )},
        content = {
            when (step) {
                1 -> {
                    appContent(
                        imageId = R.drawable.lemon_tree,
                        descriptionId = R.string.lemon_tree,
                        textId = R.string.lemon_tree_txt,
                        onClickFun = {
                            step = 2
                            counter = (2..4).random()
                        })
                }
                2 -> {
                    appContent(
                        imageId = R.drawable.lemon_squeeze,
                        descriptionId = R.string.lemon,
                        textId = R.string.lemon_txt,
                        onClickFun = {
                            counter--
                            if (counter == 0) {
                                step = 3
                            }
                        }
                    )
                }
                3 -> {
                    appContent(
                        imageId = R.drawable.lemon_drink,
                        descriptionId = R.string.lemonade,
                        textId = R.string.lemonade_txt,
                        onClickFun = {
                            step = 4
                        }
                    )
                }
                4 -> {
                    appContent(imageId = R.drawable.lemon_restart,
                        descriptionId = R.string.glass,
                        textId = R.string.glass_txt,
                        onClickFun = {
                            step = 1
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun appContent(
imageId: Int,
descriptionId: Int,
textId: Int,
onClickFun: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onClickFun,
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = blueIcon),
            modifier = Modifier
                .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(imageId),
                    contentDescription = stringResource(descriptionId)
                )
            }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = stringResource(textId),
            fontSize = 18.sp
        )
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidCourse_LemonadeTheme {
        LemonadeApp()
    }
}