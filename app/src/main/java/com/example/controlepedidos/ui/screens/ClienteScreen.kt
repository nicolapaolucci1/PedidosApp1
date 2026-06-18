package com.example.controlepedidos.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.controlepedidos.data.database.DatabaseProvider
import com.example.controlepedidos.data.entity.Cliente
import com.example.controlepedidos.repository.ClienteRepository
import com.example.controlepedidos.ui.viewmodel.ClienteViewModel
import com.example.controlepedidos.ui.viewmodel.ClienteViewModelFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@Composable
fun ClienteScreen() {


    val context = LocalContext.current


    val dao =
        DatabaseProvider
            .getDatabase(context)
            .clienteDao()


    val viewModel: ClienteViewModel =
        viewModel(
            factory =
                ClienteViewModelFactory(
                    ClienteRepository(dao)
                )
        )


    val clientes by
    viewModel.clientes.collectAsState(
        initial = emptyList()
    )


    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    val clienteEditando = remember {
        mutableStateOf<Cliente?>(null)
    }


        Column(
            modifier =
                Modifier.padding(16.dp)
        ) {


            Text(
                text = "Clientes",
                style = MaterialTheme.typography.headlineMedium
            )


            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") }
            )


            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Telefone") }
            )


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )


            OutlinedTextField(
                value = cidade,
                onValueChange = { cidade = it },
                label = { Text("Cidade") }
            )



            Button(

                onClick = {


                    viewModel.adicionar(

                        Cliente(

                            nome = nome,

                            telefone = telefone,

                            email = email,

                            cidade = cidade

                        )

                    )


                    nome = ""
                    telefone = ""
                    email = ""
                    cidade = ""


                }

            ) {

                Text("Salvar")

            }



            Spacer(
                modifier = Modifier.height(20.dp)
            )



            LazyColumn {


                items(clientes) { cliente ->


                    Card(

                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(5.dp)

                    ) {

                        Column(

                            modifier =
                                Modifier.padding(15.dp)

                        ) {

                            Text(cliente.nome)

                            Text(cliente.telefone)

                            Text(cliente.email)

                            Text(cliente.cidade)

                            Row {

                                Button(

                                    onClick = {

                                        viewModel.remover(cliente)

                                    }

                                ) {

                                    Text("Excluir")

                                }

                                Spacer(
                                    modifier =
                                        Modifier.width(10.dp)
                                )

                                Button(

                                    onClick = {

                                        clienteEditando.value = cliente

                                        nome = cliente.nome
                                        telefone = cliente.telefone
                                        email = cliente.email
                                        cidade = cliente.cidade

                                    }

                                ) {

                                    Text("Editar")

                                }

                            }

                        }

                    }


                }


            }
        }
    }
