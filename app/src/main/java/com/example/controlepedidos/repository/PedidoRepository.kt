package com.example.controlepedidos.repository


import com.example.controlepedidos.data.dao.PedidoDao
import com.example.controlepedidos.data.entity.Pedido



class PedidoRepository(

    private val dao: PedidoDao

){



    fun listar() =
        dao.listar()



    suspend fun inserir(
        pedido: Pedido
    ){

        dao.inserir(pedido)

    }



    suspend fun excluir(
        pedido: Pedido
    ){

        dao.excluir(pedido)

    }


}