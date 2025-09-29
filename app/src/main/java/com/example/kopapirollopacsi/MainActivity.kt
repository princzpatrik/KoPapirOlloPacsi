package com.example.kopapirollopacsi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kopapirollopacsi.ui.theme.KoPapirOlloPacsiTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoPapirOlloPacsiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KoPapirOllo(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun KoPapirOllo(modifier: Modifier = Modifier) {
    var valasztas by remember { mutableStateOf(" ") }
    var gyozelmek by remember { mutableIntStateOf(0) }
    var jatekVege by remember { mutableStateOf(false) }

    val list = listOf("🪨", "🧻", "✂️")
    var gepvalasztas by remember { mutableStateOf(list.random()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        if (valasztas != " ") {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Játékos: $valasztas")
                Text(text = " Gép: $gepvalasztas")
                Text(text = "Játékos győzelmeinek a száma: $gyozelmek")
            }
        }

        // Játék eredményei
        if (valasztas == "🪨" && gepvalasztas == "🪨") {
            Text(text = "Döntetlen.")
        } else if (valasztas == "🪨" && gepvalasztas == "🧻") {
            Text(text = "A gép nyert.")
        } else if (valasztas == "🪨" && gepvalasztas == "✂️") {
            Text(text = "A játékos nyert.")
            if (!jatekVege) {
                gyozelmek += 1
                jatekVege = true
            }
        } else if (valasztas == "🧻" && gepvalasztas == "🧻") {
            Text(text = "Döntetlen.")
        } else if (valasztas == "🧻" && gepvalasztas == "🪨") {
            Text(text = "A játékos nyert.")
            if (!jatekVege) {
                gyozelmek += 1
                jatekVege = true
            }
        } else if (valasztas == "🧻" && gepvalasztas == "✂️") {
            Text(text = "A gép nyert.")
        } else if (valasztas == "✂️" && gepvalasztas == "✂️") {
            Text(text = "Döntetlen.")
        } else if (valasztas == "✂️" && gepvalasztas == "🪨") {
            Text(text = "A gép nyert.")
        } else if (valasztas == "✂️" && gepvalasztas == "🧻") {
            Text(text = "A játékos nyert.")
            if (!jatekVege) {
                gyozelmek += 1
                jatekVege = true
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                valasztas = "🪨"
                gepvalasztas = list.random()
                jatekVege = false
            }) {
                Text(text = "🪨")
            }

            Button(onClick = {
                valasztas = "🧻"
                gepvalasztas = list.random()
                jatekVege = false
            }) {
                Text(text = "🧻")
            }

            Button(onClick = {
                valasztas = "✂️"
                gepvalasztas = list.random()
                jatekVege = false
            }) {
                Text(text = "✂️")
            }
        }
    }
}
