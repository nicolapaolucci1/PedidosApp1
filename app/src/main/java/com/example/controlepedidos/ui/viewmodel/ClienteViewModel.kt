package com.example.controlepedidos.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlepedidos.data.entity.Cliente
import com.example.controlepedidos.repository.ClienteRepository
import kotlinx.coroutines.launch

class ClienteViewModel(
    private val repository: ClienteRepository
): ViewModel(){

    val clientes = repository.listar()

    fun adicionar(cliente: Cliente){

        viewModelScope.launch {
            repository.inserir(cliente)
        }

    }

    fun atualizar(cliente: Cliente){

        viewModelScope.launch {
            repository.atualizar(cliente)
        }

    }

    fun remover(cliente: Cliente){

        viewModelScope.launch {
            repository.excluir(cliente)
        }

    }

}