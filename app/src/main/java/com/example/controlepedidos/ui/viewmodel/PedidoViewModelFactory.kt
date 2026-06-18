package com.example.controlepedidos.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.controlepedidos.repository.PedidoRepository



class PedidoViewModelFactory(

    private val repository: PedidoRepository

): ViewModelProvider.Factory {



    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {


        return PedidoViewModel(
            repository
        ) as T


    }


}