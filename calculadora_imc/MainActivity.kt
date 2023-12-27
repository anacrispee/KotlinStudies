package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImcCalculator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcCalculator(
){
    var weightInput by remember { mutableStateOf("") }
    var heightInput by remember { mutableStateOf("") }

    val weight = weightInput.toDoubleOrNull() ?: 0.0
    val height = heightInput.toDoubleOrNull() ?: 0.0

    var result by remember { mutableStateOf(0.0) }

    val resultTxt = when (result) {
        in 1.0..18.5 -> R.string.abaixo_do_peso
        in 18.6..24.9 -> R.string.peso_ideal
        in 25.0..29.9 -> R.string.lev_acima_peso
        in 30.0..34.9 -> R.string.obesidade_i
        in 35.0..39.9 -> R.string.obesidade_ii
        in 40.0..1000.0 -> R.string.obesidade_iii
            else -> R.string.sem_dados
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF756AB6)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(30.dp),
            text = "IMC Calculator"
        )
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFFE5E5),
                textColor = Color(0xFF756AB6)
            ),
            modifier = Modifier
                .padding(10.dp),
            singleLine = true,
            value = weightInput,
            onValueChange = { weightInput = it },
            label = { Text(text = "Weight") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFE5E5)),
            modifier = Modifier
                .padding(10.dp),
            singleLine = true,
            value = heightInput,
            onValueChange = { heightInput = it },
            label = { Text(text = "Height") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFE5E5)),
            modifier = Modifier
                .padding(10.dp),
            onClick = {
            result = calculateImc(weight, height)
        }) {
            Text(
                color = Color(0xFF756AB6),
                text = "Calculate"
            )
        }
        Text(
            color = Color.White,
            text = stringResource(resultTxt)
        )
    }
}

fun calculateImc(
    weight: Double,
    height: Double
): Double {
    val result = weight / (height * height)
    return  result
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CalculadoraIMCTheme {
        ImcCalculator()
    }
}