package com.example.controlepedidos.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlepedidos.data.entity.Pedido
import com.example.controlepedidos.repository.PedidoRepository
import kotlinx.coroutines.launch



class PedidoViewModel(

    private val repository: PedidoRepository

): ViewModel(){



    val pedidos =
        repository.listar()



    fun adicionar(
        pedido: Pedido
    ){

        viewModelScope.launch {


            repository.inserir(
                pedido
            )


        }

    }



    fun excluir(
        pedido: Pedido
    ){

        viewModelScope.launch {


            repository.excluir(
                pedido
            )


        }

    }



}