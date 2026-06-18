package com.example.controlepedidos.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.controlepedidos.ui.screens.*



@Composable
fun AppNavigation(){


    val navController =
        rememberNavController()



    NavHost(

        navController,

        startDestination="login"

    ){



        composable("login"){


            LoginScreen(
                navController
            )


        }



        composable("home"){


            HomeScreen(navController)


        }



        composable("clientes"){


            ClienteScreen()


        }
        composable("produtos"){

            ProdutoScreen()

        }


        composable("pedidos"){

            PedidoScreen()

        }


        composable("config"){

            ConfigScreen()

        }

    }


}