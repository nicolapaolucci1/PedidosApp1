package com.example.controlepedidos.data.database


import android.content.Context
import androidx.room.Room
import com.example.controlepedidos.data.entity.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



object DatabaseProvider {


    private var database: AppDatabase? = null



    fun getDatabase(context: Context): AppDatabase {


        if(database == null){


            database =
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "controle_pedidos.db"
                )
                    .build()



            criarUsuarioPadrao()

        }


        return database!!

    }



    private fun criarUsuarioPadrao(){


        CoroutineScope(
            Dispatchers.IO
        ).launch{


            val dao =
                database!!.usuarioDao()


            dao.inserir(

                Usuario(

                    usuario="admin",

                    senha="1234"

                )

            )


        }


    }


}