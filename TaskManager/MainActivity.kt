package com.example.androidcourse_taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_taskmanager.ui.theme.AndroidCourse_TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourse_TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        taskImage()
                        title(text = stringResource(R.string.title))
                        phrase(text = stringResource(R.string.phrase))
                    }
                }
            }
        }
    }
}

@Composable
fun taskImage() {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun title(
    text: String
){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp
            )
    )
}

@Composable
fun phrase(
    text: String
){
    Text(
        text = text
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidCourse_TaskManagerTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            taskImage()
            title(text = stringResource(R.string.title))
            phrase(text = stringResource(R.string.phrase))
        }
    }
}