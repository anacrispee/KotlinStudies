package com.example.androidcourse_composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_composearticle.ui.theme.AndroidCourse_ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourse_ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ImageBanner()
                        titleText(
                            text = stringResource(R.string.compose_tutorial_title)
                        )
                        firstParagraph(
                            text = stringResource(R.string.compose_tutorial_fst_paragraph)
                        )
                        scndtParagraph(
                            text = stringResource(R.string.compose_tutorial_secnd_paragraph)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageBanner() {
    val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
}

@Composable
fun titleText(
    text: String
) {
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = text,
        fontSize = 24.sp,
    )
}

@Composable
fun firstParagraph(
    text: String
) {
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = text,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun scndtParagraph(
    text: String
) {
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = text,
        textAlign = TextAlign.Justify
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidCourse_ComposeArticleTheme {
        Column {
            ImageBanner()
            titleText(
                text = stringResource(R.string.compose_tutorial_title)
            )
            firstParagraph(
                text = stringResource(R.string.compose_tutorial_fst_paragraph)
            )
            scndtParagraph(
                text = stringResource(R.string.compose_tutorial_secnd_paragraph)
            )
        }
    }
}