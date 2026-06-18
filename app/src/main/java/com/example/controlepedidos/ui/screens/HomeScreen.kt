package com.example.controlepedidos.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController



@Composable
fun HomeScreen(
    navController: NavHostController
){


    Column {


        Text(
            text="Controle de Pedidos"
        )


        Button(

            onClick={

                navController.navigate("clientes")

            }

        ){

            Text("Clientes")

        }



        Button(

            onClick={

                navController.navigate("produtos")

            }

        ){

            Text("Produtos")

        }



        Button(

            onClick={

                navController.navigate("pedidos")

            }

        ){

            Text("Pedidos")

        }



        Button(

            onClick={

                navController.navigate("config")

            }

        ){

            Text("Configurações")

        }



    }


}