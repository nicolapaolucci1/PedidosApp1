package com.example.controlepedidos.data.dao


import androidx.room.*
import com.example.controlepedidos.data.entity.Pedido
import com.example.controlepedidos.data.entity.PedidoCompleto
import kotlinx.coroutines.flow.Flow



@Dao
interface PedidoDao{


    @Transaction
    @Query("SELECT * FROM Pedido")
    fun listar():
            Flow<List<PedidoCompleto>>



    @Insert

    suspend fun inserir(
        pedido:Pedido
    )



    @Delete

    suspend fun excluir(
        pedido:Pedido
    )


}