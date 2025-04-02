package com.example.cardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardapp.ui.theme.CardAppTheme
import androidx.compose.ui.graphics.Color // next 3 для градиента
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFD1DC),
                                    Color(0xFFFFDAC1),
                                    Color(0xFFB5EAD7),
                                )
                            )
                        )
                ) {
                    businessCard()
                }

            }
        }
    }
}

@Composable
fun businessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        // лого, имя, дев
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Лого приложения",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 24.dp)
            )

            Text(
                text = "Azamat Fazlyev",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Android Developer",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // нижняя часть экрана (контакты)
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            Text(
                text = "Phone: +7 917 676-15-14",
                fontSize = 14.sp
            )
            Text(
                text = "@Deffectivny",
                fontSize = 14.sp
            )
            Text(
                text = "Email: afazlyev74@gmail.com",
                fontSize = 14.sp
            )
        }
    }
}

