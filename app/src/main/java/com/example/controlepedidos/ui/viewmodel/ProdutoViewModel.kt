package com.example.controlepedidos.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlepedidos.data.entity.Produto
import com.example.controlepedidos.repository.ProdutoRepository
import kotlinx.coroutines.launch

class ProdutoViewModel(

    private val repository: ProdutoRepository

): ViewModel(){

    val produtos =
        repository.listar()

    fun adicionar(
        produto: Produto
    ){

        viewModelScope.launch {

            repository.inserir(produto)

        }

    }

    fun atualizar(
        produto: Produto
    ){

        viewModelScope.launch {

            repository.atualizar(produto)

        }

    }

    fun remover(
        produto: Produto
    ){

        viewModelScope.launch {

            repository.excluir(produto)

        }

    }

}