package com.example.controlepedidos.data.dao


import androidx.room.*
import com.example.controlepedidos.data.entity.Cliente
import kotlinx.coroutines.flow.Flow


@Dao
interface ClienteDao {


    @Query("SELECT * FROM Cliente")
    fun listarClientes(): Flow<List<Cliente>>


    @Insert
    suspend fun inserir(cliente: Cliente)


    @Update
    suspend fun atualizar(cliente: Cliente)


    @Delete
    suspend fun excluir(cliente: Cliente)

}