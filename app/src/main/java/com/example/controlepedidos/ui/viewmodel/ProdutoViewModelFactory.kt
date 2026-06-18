package com.example.controlepedidos.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.controlepedidos.repository.ProdutoRepository



class ProdutoViewModelFactory(

    private val repository:ProdutoRepository

):ViewModelProvider.Factory{


    override fun <T:ViewModel> create(
        modelClass:Class<T>
    ):T{


        return ProdutoViewModel(repository)
                as T


    }


}