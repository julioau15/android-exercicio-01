package com.aulasandroid.exercicio01_game_layout

import android.R.attr.fontWeight
import android.R.attr.text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.exercicio01_game_layout.ui.theme.Exercicio01gamelayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicio01gamelayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier
) {
    var telaAtual by remember { mutableStateOf("start") }

    when (telaAtual) {

        "start" -> {
            TelaStart(
                modifier = modifier,
                onStartClick = {
                    telaAtual = "gameover"
                }
            )
        }

        "gameover" -> {
            TelaGameOver(
                modifier = modifier
            )
        }
    }
}

@Composable
fun TelaStart(
    modifier: Modifier = Modifier,
    onStartClick: () -> Unit
){
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(10.dp, 40.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SCORE: 0050",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "LIVES:",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    AndroidEnemy(
                        color = Color.Green,
                        modifier = Modifier
                            .size(50.dp)
                    )

                    AndroidEnemy(
                        color = Color.Green,
                        modifier = Modifier
                            .size(50.dp)
                    )

                    AndroidEnemy(
                        color = Color.Green,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }

            Row(

            ) {
                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier
                        .weight(1f)
                )

                AndroidEnemy(
                    color = Color.Red,
                    modifier = Modifier
                        .weight(1f)
                )

                AndroidEnemy(
                    color = Color.Blue,
                    modifier = Modifier
                        .weight(1f)
                )

                AndroidEnemy(
                    color = Color.Yellow,
                    modifier = Modifier
                        .weight(1f)
                )

                AndroidEnemy(
                    color = Color.Green,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier
                    .size(150.dp)
            )


            Button(
                onClick = {onStartClick()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ){
                Text(
                    text = "PRESS START",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }

}

@Composable
fun TelaGameOver(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Row(

        ) {
            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier
                    .weight(1f)
            )

            AndroidEnemy(
                color = Color.Red,
                modifier = Modifier
                    .weight(1f)
            )

            AndroidEnemy(
                color = Color.Blue,
                modifier = Modifier
                    .weight(1f)
            )

            AndroidEnemy(
                color = Color.Yellow,
                modifier = Modifier
                    .weight(1f)
            )

            AndroidEnemy(
                color = Color.Green,
                modifier = Modifier
                    .weight(1f)
            )
        }

        Text(
            text = "GAME OVER",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 65.sp
        )
    }

}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}