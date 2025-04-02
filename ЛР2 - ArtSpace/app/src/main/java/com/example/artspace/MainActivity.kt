package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.artspace.ui.theme.artSpaceAppTheme
import androidx.compose.ui.graphics.graphicsLayer //для тени

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            artSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    artSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun artSpaceScreen() {
    // сохраняем текущий индекс
    var currentIndex by remember { mutableStateOf(0) }

    // cписки для картин
    val images = listOf(
        "slivochnoe_maslo",
        "bruh",
        "tromb"
    )

    val titles = listOf(
        "\"Масло сливочное\"",
        "\"BRUH\"",
        "\"Trumb\""
    )

    val authors = listOf(
        "dumb_gooze (2019)",
        "Deffectivny (2024)",
        "Ребе Курт (2024)"
    )

    // контекст для работы с ресурсами
    val context = LocalContext.current

    // Функция для получения картинки по имени
    fun getImageResourceId(imageName: String): Int {
        return try {
            // Получаем id картинки
            val resId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
            resId
        } catch (e: Exception) {
            0 // Если ресурс не найден, возвращаем 0
        }
    }

    // функция для проверки наличия картинки
    fun isImageAvailable(imageName: String): Boolean {
        return try {
            // Попытка загрузить изображение
            val resId = getImageResourceId(imageName)
            resId != 0
        } catch (e: Exception) {
            false
        }
    }

    // Изображение и текст
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // проверка - есть ли изображение в списке
        when (isImageAvailable(images[currentIndex])) {
            true -> Image(
                painter = painterResource(id = context.resources.getIdentifier(images[currentIndex], "drawable", context.packageName)),
                contentDescription = null,
                modifier = Modifier
                    .size(280.dp)
                    .padding(bottom = 20.dp)
                    .graphicsLayer(
                        shadowElevation = 12f, // тень по бокам
                        shape = MaterialTheme.shapes.medium,
                        clip = true
                    )
            )
            false -> Text("Изображение не найдено") // Если изображение не найдено
        }

        // Название
        Text(
            text = titles[currentIndex],
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Автор + год
        Text(
            text = authors[currentIndex],
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Кнопки: "назад" и "вперед"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentIndex = (currentIndex - 1 + images.size) % images.size
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text("назад", fontSize = 16.sp)
            }

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % images.size
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp)
            ) {
                Text("вперед", fontSize = 16.sp)
            }
        }
    }
}
