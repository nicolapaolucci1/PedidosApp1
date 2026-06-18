@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.controlepedidos.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.controlepedidos.data.database.DatabaseProvider
import com.example.controlepedidos.data.entity.Pedido
import com.example.controlepedidos.repository.PedidoRepository
import com.example.controlepedidos.ui.viewmodel.PedidoViewModel
import com.example.controlepedidos.ui.viewmodel.PedidoViewModelFactory
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



@Composable
fun PedidoScreen(){


    val context = LocalContext.current

    val database =
        DatabaseProvider
            .getDatabase(context)

    val pedidoDao =
        database.pedidoDao()

    val produtoDao =
        database.produtoDao()

    val clienteDao =
        database.clienteDao()


    val viewModel: PedidoViewModel =
        viewModel(

            factory =
                PedidoViewModelFactory(

                    PedidoRepository(
                        pedidoDao
                    )
                )
        )


    val scope = rememberCoroutineScope()

    val pedidos by
    viewModel.pedidos.collectAsState(
        initial = emptyList()
    )

    val clientes by
    clienteDao
        .listarClientes()
        .collectAsState(
            initial = emptyList()
        )

    val produtos by
    produtoDao
        .listar()
        .collectAsState(
            initial = emptyList()
        )


    var clienteSelecionado by remember {
        mutableStateOf<com.example.controlepedidos.data.entity.Cliente?>(null)
    }

    var produtoSelecionado by remember {
        mutableStateOf<com.example.controlepedidos.data.entity.Produto?>(null)
    }

    var quantidade by remember {
        mutableStateOf("")
    }

    var data by remember {
        mutableStateOf("")
    }

    var hora by remember {
        mutableStateOf("")
    }

    var mostrarData by remember {
        mutableStateOf(false)
    }

    var mostrarDialogo by remember {
        mutableStateOf(false)
    }

    var pedidoSelecionado by remember {
        mutableStateOf<Pedido?>(null)
    }

    var mostrarHora by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier.padding(16.dp)
    ){

        Text(
            text = "Pedidos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(10.dp))

        Text("Cliente selecionado:")

        Text(
            clienteSelecionado?.nome ?: "Nenhum cliente selecionado"
        )

        clientes.forEach { cliente ->

            Button(
                onClick = {
                    clienteSelecionado = cliente
                }
            ){
                Text(cliente.nome)
            }

        }

        Spacer(Modifier.height(10.dp))

        Text("Produto selecionado:")

        Text(
            produtoSelecionado?.nome ?: "Nenhum produto selecionado"
        )

        produtos.forEach { produto ->

            Button(
                onClick = {
                    produtoSelecionado = produto
                }
            ){
                Text(produto.nome)
            }

        }

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(

            value = quantidade,

            onValueChange = {
                quantidade = it
            },

            label = {
                Text("Quantidade")
            }

        )

        Spacer(Modifier.height(10.dp))

        Button(
            onClick = {
                mostrarData = true
            }
        ){
            Text(
                if(data.isEmpty())
                    "Escolher data"
                else
                    data
            )
        }

        Button(
            onClick = {
                mostrarHora = true
            }
        ){
            Text(
                if(hora.isEmpty())
                    "Escolher hora"
                else
                    hora
            )
        }

        Spacer(Modifier.height(10.dp))

        Button(

            onClick = {

                if(
                    clienteSelecionado == null ||
                    produtoSelecionado == null ||
                    quantidade.isEmpty()
                ){
                    return@Button
                }

                scope.launch {

                    val total =

                        (produtoSelecionado?.valor ?: 0.0) *

                                (quantidade.toIntOrNull() ?: 0)

                    viewModel.adicionar(

                        Pedido(

                            clienteId =
                                clienteSelecionado!!.id,

                            produtoId =
                                produtoSelecionado!!.id,

                            quantidade =
                                quantidade.toInt(),

                            data = data,

                            hora = hora,

                            valorTotal = total

                        )

                    )

                }

            }

        ){
            Text("Salvar Pedido")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyColumn {

            items(pedidos){ item ->

                Card(

                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp)

                ){

                    Column(

                        modifier =
                            Modifier.padding(15.dp)

                    ){

                        Text(
                            "Cliente: ${item.cliente?.nome ?: "Cliente removido"}"
                        )

                        Text(
                            "Produto: ${item.produto?.nome ?: "Produto removido"}"
                        )

                        Text(
                            "Quantidade: ${item.pedido.quantidade}"
                        )

                        Text(
                            "Data: ${item.pedido.data}"
                        )

                        Text(
                            "Hora: ${item.pedido.hora}"
                        )

                        Text(
                            "Total: R$ ${item.pedido.valorTotal}"
                        )

                        Button(

                            onClick = {

                                pedidoSelecionado =
                                    item.pedido

                                mostrarDialogo = true

                            }

                        ){

                            Text("Excluir")

                        }

                    }

                }

            }

        }

    }

        if(mostrarData){

            val state =
                rememberDatePickerState()


            DatePickerDialog(


                onDismissRequest = {

                    mostrarData=false
                },

                confirmButton = {


                    TextButton(

                        onClick = {

                            val millis =
                                state.selectedDateMillis

                            if(millis != null){

                                data =

                                    SimpleDateFormat(

                                        "dd/MM/yyyy",

                                        Locale.getDefault()
                                    )

                                        .format(

                                            Date(millis)

                                        )
                            }
                            mostrarData=false
                        }
                    ){

                        Text("OK")

                    }
                }
            ){

                DatePicker(

                    state = state

                )
            }
        }

        if(mostrarHora){


            val timeState =
                rememberTimePickerState()


            AlertDialog(


                onDismissRequest = {

                    mostrarHora=false
                },

                confirmButton = {


                    TextButton(

                        onClick = {


                            hora =

                                String.format(

                                    Locale.getDefault(),

                                    "%02d:%02d",

                                    timeState.hour,

                                    timeState.minute
                                )


                            mostrarHora=false
                        }
                    ){

                        Text("OK")
                    }
                },

                dismissButton = {


                    TextButton(

                        onClick = {

                            mostrarHora=false
                        }
                    ){

                        Text("Cancelar")
                    }
                },

                text = {


                    TimePicker(

                        state=timeState
                    )
                }
            )
        }



    if(mostrarDialogo){


        AlertDialog(


            onDismissRequest = {

                mostrarDialogo=false
            },


            title = {

                Text(
                    "Excluir pedido"
                )
            },


            text = {

                Text(
                    "Deseja realmente excluir?"
                )
            },


            confirmButton = {

                TextButton(

                    onClick = {

                        pedidoSelecionado?.let {

                            viewModel.excluir(it)

                        }

                        mostrarDialogo=false


                    }
                ){

                    Text("Sim")

                }
            },

            dismissButton = {


                TextButton(

                    onClick = {

                        mostrarDialogo=false

                    }

                ){

                    Text("Cancelar")

                }
            }
        )
    }
}