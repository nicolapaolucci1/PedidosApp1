package com.example.controlepedidos.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Usuario(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    val usuario:String,

    val senha:String

)