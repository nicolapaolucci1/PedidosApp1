package com.example.controlepedidos.repository

import com.example.controlepedidos.data.dao.ClienteDao
import com.example.controlepedidos.data.entity.Cliente

class ClienteRepository(
    private val dao: ClienteDao
){

    fun listar() =
        dao.listarClientes()

    suspend fun inserir(cliente: Cliente){
        dao.inserir(cliente)
    }

    suspend fun atualizar(cliente: Cliente){
        dao.atualizar(cliente)
    }

    suspend fun excluir(cliente: Cliente){
        dao.excluir(cliente)
    }

}