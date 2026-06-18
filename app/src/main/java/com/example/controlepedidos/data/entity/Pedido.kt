package com.example.controlepedidos.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class Pedido(


    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,


    val clienteId:Int,


    val produtoId:Int,


    val quantidade:Int,


    val data:String,


    val hora:String,


    val valorTotal:Double


)