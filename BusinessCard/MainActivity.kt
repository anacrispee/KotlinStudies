package com.example.androidcourse_businesscard

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcourse_businesscard.ui.theme.AndroidCourse_BusinessCardTheme
import com.example.androidcourse_businesscard.ui.theme.DarkBlue
import com.example.androidcourse_businesscard.ui.theme.LightGreen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourse_BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainComposable()
                }
            }
        }
    }
}

@Composable
fun centerBox(
    fullName: String,
    title: String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val androidImage = painterResource(R.drawable.android_logo)
        Box(modifier = Modifier
            .background(color = DarkBlue)
        ){
            Image(
                painter = androidImage,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            )
        }
        Text(
            text = fullName,
            fontSize = 30.sp
        )
        Text(
            text = title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBlue
        )
    }
}

@Composable
fun info(
    info: String,
    image: Painter
){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(5.dp)
        ) {
            androidx.compose.foundation.Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = info,
                fontSize = 15.sp
            )
        }
}

@Composable
fun mainComposable(){
    Column(
        modifier = Modifier
            .background(color = LightGreen),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        centerBox(
            fullName = "Ana Cristina",
            title = "Estagiária em Desenvolvimento Mobile"
        )
        Spacer(
            modifier = Modifier
                .size(200.dp)
        )
        Column {
            info(info = "(47) 9 9652-9929", image = painterResource(R.drawable.ic_phone))
            info(info = "anacrispee", image = painterResource(R.drawable.ic_share))
            info(info = "anacrispee@gmail.com", image = painterResource(R.drawable.ic_email))
        }
        Spacer(
            modifier = Modifier
                .size(60.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidCourse_BusinessCardTheme {
        mainComposable()
    }
}