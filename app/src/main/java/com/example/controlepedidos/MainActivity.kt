package com.example.controlepedidos


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.controlepedidos.navigation.AppNavigation
import androidx.compose.material3.MaterialTheme
class MainActivity : ComponentActivity(){

    override fun onCreate(
        savedInstanceState: Bundle?
    ){

        super.onCreate(savedInstanceState)


        setContent {


            MaterialTheme {


                AppNavigation()


            }


        }

    }

}


@Composable
fun TelaTeste(){

    Text(
        text="Controle de Pedidos"
    )

}
