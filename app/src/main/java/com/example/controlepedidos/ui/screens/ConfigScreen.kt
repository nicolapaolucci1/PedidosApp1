package com.example.controlepedidos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.controlepedidos.data.datastore.SettingsDataStore

@Composable
fun ConfigScreen() {

    val context = LocalContext.current

    val dataStore =
        SettingsDataStore(context)

    val scope = rememberCoroutineScope()

    val usernameFlow =
        dataStore.username.collectAsState(
            initial = ""
        )

    val darkModeFlow =
        dataStore.darkMode.collectAsState(
            initial = false
        )

    var username by remember {
        mutableStateOf("")
    }

    var darkMode by remember {
        mutableStateOf(darkModeFlow.value)
    }

    Column(
        modifier = Modifier.padding(22.dp)
    ) {

        Text(
            "Configurações",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(

            value = usernameFlow.value,

            onValueChange = {

                username = it

            },

            label = {
                Text("Nome do usuário")
            }

        )

        Button(

            onClick = {

                scope.launch {

                    dataStore.salvarUsername(
                        username
                    )

                }

            }

        ) {

            Text("Salvar nome")

        }

        Spacer(
            Modifier.height(20.dp)
        )

        Row {

            Text("Tema escuro")

            Spacer(
                Modifier.width(10.dp)
            )

            Switch(

                checked = darkModeFlow.value,

                onCheckedChange = {

                    darkMode = it

                    scope.launch {

                        dataStore.salvarDarkMode(it)

                    }

                }

            )

        }

    }

}