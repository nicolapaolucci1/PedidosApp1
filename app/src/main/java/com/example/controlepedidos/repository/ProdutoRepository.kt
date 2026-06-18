package com.example.controlepedidos.repository

import com.example.controlepedidos.data.dao.ProdutoDao
import com.example.controlepedidos.data.entity.Produto

class ProdutoRepository(

    private val dao: ProdutoDao

){

    fun listar() =
        dao.listar()

    suspend fun inserir(
        produto: Produto
    ){
        dao.inserir(produto)
    }

    suspend fun atualizar(
        produto: Produto
    ){
        dao.atualizar(produto)
    }

    suspend fun excluir(
        produto: Produto
    ){
        dao.excluir(produto)
    }

}