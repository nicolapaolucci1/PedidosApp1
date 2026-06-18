package com.example.controlepedidos.data.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.controlepedidos.data.dao.*
import com.example.controlepedidos.data.entity.*



@Database(

    entities = [

        Cliente::class,

        Usuario::class,

        Produto::class,

        Pedido::class
    ],

    version = 1

)


abstract class AppDatabase:RoomDatabase(){


    abstract fun clienteDao():ClienteDao


    abstract fun usuarioDao():UsuarioDao


    abstract fun produtoDao():ProdutoDao


    abstract fun pedidoDao():PedidoDao

}