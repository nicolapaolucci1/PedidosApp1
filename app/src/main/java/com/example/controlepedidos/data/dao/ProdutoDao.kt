package com.example.controlepedidos.data.dao


import androidx.room.*
import com.example.controlepedidos.data.entity.Produto
import kotlinx.coroutines.flow.Flow



@Dao
interface ProdutoDao{


    @Query("SELECT * FROM Produto")
    fun listar(): Flow<List<Produto>>



    @Insert
    suspend fun inserir(
        produto:Produto
    )

    @Update
    suspend fun atualizar(
        produto: Produto
    )

    @Delete
    suspend fun excluir(
        produto:Produto
    )


}