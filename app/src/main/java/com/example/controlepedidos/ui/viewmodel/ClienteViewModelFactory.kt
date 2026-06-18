package com.example.controlepedidos.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.controlepedidos.repository.ClienteRepository


class ClienteViewModelFactory(
    private val repository: ClienteRepository
): ViewModelProvider.Factory {


    override fun <T: ViewModel> create(
        modelClass: Class<T>
    ): T {


        if(modelClass.isAssignableFrom(ClienteViewModel::class.java)){

            return ClienteViewModel(repository) as T

        }


        throw IllegalArgumentException(
            "ViewModel desconhecido"
        )


    }


}