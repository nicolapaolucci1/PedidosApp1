package com.example.controlepedidos.data.dao


import androidx.room.*
import com.example.controlepedidos.data.entity.Usuario


@Dao
interface UsuarioDao{


    @Query(
        "SELECT * FROM Usuario WHERE usuario=:user AND senha=:pass"
    )
    suspend fun login(
        user:String,
        pass:String
    ): Usuario?



    @Insert
    suspend fun inserir(
        usuario: Usuario
    )


}