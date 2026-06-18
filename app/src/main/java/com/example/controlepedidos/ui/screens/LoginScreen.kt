package com.example.controlepedidos.ui.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.navigation.NavHostController
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import com.example.controlepedidos.data.database.DatabaseProvider
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController
) {

    val context = LocalContext.current


    val dao =
        DatabaseProvider
            .getDatabase(context)
            .usuarioDao()


    val scope = rememberCoroutineScope()



    var usuario by remember {
        mutableStateOf("")
    }


    var senha by remember {
        mutableStateOf("")
    }



    var mensagem by remember {
        mutableStateOf("")
    }



    Column{


        Text(
            "Login"
        )


        OutlinedTextField(

            value=usuario,

            onValueChange={
                usuario=it
            },

            label={
                Text("Usuário")
            }

        )


        OutlinedTextField(

            value=senha,

            onValueChange={
                senha=it
            },

            label={
                Text("Senha")
            }

        )



        Button(

            onClick={


                scope.launch{


                    val resultado =
                        dao.login(
                            usuario,
                            senha
                        )


                    if(resultado == null){

                        mensagem =
                            "Usuário ou senha inválidos"

                    }else{


                        navController.navigate("home")


                    }


                }


            }

        ){

            Text("Entrar")

        }



        Text(
            mensagem
        )


    }


}