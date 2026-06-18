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
import com.example.controlepedidos.data.entity.Produto
import com.example.controlepedidos.repository.ProdutoRepository
import com.example.controlepedidos.ui.viewmodel.ProdutoViewModel
import com.example.controlepedidos.ui.viewmodel.ProdutoViewModelFactory



@Composable
fun ProdutoScreen(){


    val context = LocalContext.current



    val dao =
        DatabaseProvider
            .getDatabase(context)
            .produtoDao()



    val viewModel: ProdutoViewModel =
        viewModel(

            factory =
                ProdutoViewModelFactory(

                    ProdutoRepository(dao)

                )

        )



    val produtos by
    viewModel.produtos.collectAsState(
        initial = emptyList()
    )



    var nome by remember {
        mutableStateOf("")
    }


    var descricao by remember {
        mutableStateOf("")
    }


    var valor by remember {
        mutableStateOf("")
    }


    var estoque by remember {
        mutableStateOf("")
    }

    val produtoEditando = remember {
        mutableStateOf<Produto?>(null)
    }



    Column(

        modifier =
            Modifier.padding(16.dp)

    ){


        Text(
            text="Produtos",
            style=MaterialTheme.typography.headlineMedium
        )



        OutlinedTextField(

            value=nome,

            onValueChange={
                nome=it
            },

            label={
                Text("Nome")
            }

        )



        OutlinedTextField(

            value=descricao,

            onValueChange={
                descricao=it
            },

            label={
                Text("Descrição")
            }

        )



        OutlinedTextField(

            value=valor,

            onValueChange={
                valor=it
            },

            label={
                Text("Valor")
            }

        )



        OutlinedTextField(

            value=estoque,

            onValueChange={
                estoque=it
            },

            label={
                Text("Estoque")
            }

        )



        Button(

            onClick = {

                if(produtoEditando.value == null){

                    viewModel.adicionar(

                        Produto(

                            nome = nome,

                            descricao = descricao,

                            valor =
                                valor.toDoubleOrNull()
                                    ?: 0.0,

                            estoque =
                                estoque.toIntOrNull()
                                    ?: 0

                        )

                    )

                }else{

                    viewModel.atualizar(

                        Produto(

                            id = produtoEditando.value!!.id,

                            nome = nome,

                            descricao = descricao,

                            valor =
                                valor.toDoubleOrNull()
                                    ?: 0.0,

                            estoque =
                                estoque.toIntOrNull()
                                    ?: 0

                        )

                    )

                    produtoEditando.value = null

                }

                nome = ""
                descricao = ""
                valor = ""
                estoque = ""

            }

        ){

            Text("Salvar")

        }



        Spacer(
            modifier =
                Modifier.height(20.dp)
        )



        LazyColumn{


            items(produtos){ produto ->



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

                        Text(produto.nome)

                        Text(produto.descricao)

                        Text("R$ ${produto.valor}")

                        Text("Estoque: ${produto.estoque}")

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Row {

                            Button(

                                onClick = {

                                    viewModel.remover(produto)

                                }

                            ){

                                Text("Excluir")

                            }

                            Spacer(
                                modifier =
                                    Modifier.width(10.dp)
                            )

                            Button(

                                onClick = {

                                    produtoEditando.value = produto

                                    nome = produto.nome
                                    descricao = produto.descricao
                                    valor = produto.valor.toString()
                                    estoque = produto.estoque.toString()

                                }

                            ){

                                Text("Editar")

                            }

                        }

                    }

                }


            }



        }



    }



}