package com.example.controlepedidos.data.entity


import androidx.room.Embedded
import androidx.room.Relation



data class PedidoCompleto(

    @Embedded
    val pedido: Pedido,

    @Relation(
        parentColumn = "clienteId",
        entityColumn = "id"
    )
    val cliente: Cliente?,

    @Relation(
        parentColumn = "produtoId",
        entityColumn = "id"
    )
    val produto: Produto?

)



