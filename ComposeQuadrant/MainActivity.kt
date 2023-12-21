package com.example.androidcourse_composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcourse_composequadrant.ui.theme.AndroidCourse_ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourse_ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposable()
                }
            }
        }
    }
}

@Composable
private fun ComposableCard(
    title: String,
    paragraph: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .size(width = 200.dp, height = 400.dp)
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun MainComposable(){
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            ComposableCard(
                title = stringResource(R.string.text_composable_title),
                paragraph = stringResource(R.string.text_composable_paragraph),
                backgroundColor = colorResource(R.color.purple),
                modifier = Modifier
                    .weight(1f))

            ComposableCard(
                title = stringResource(R.string.image_composable_title),
                paragraph = stringResource(R.string.image_composable_paragraph),
                backgroundColor = colorResource(R.color.dark_purple),
                modifier = Modifier
                    .weight(1f))
        }
        Row(
            Modifier.weight(1f)
        ) {
            ComposableCard(
                title = stringResource(R.string.row_composable_title),
                paragraph = stringResource(R.string.row_composable_paragraph),
                backgroundColor = colorResource(R.color.dark_purple),
                modifier = Modifier
                    .weight(1f))

            ComposableCard(
                title = stringResource(R.string.column_composable_title),
                paragraph = stringResource(R.string.column_composable_paragraph),
                backgroundColor = colorResource(R.color.purple),
                modifier = Modifier
                    .weight(1f))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidCourse_ComposeQuadrantTheme {
        MainComposable()
        }
    }