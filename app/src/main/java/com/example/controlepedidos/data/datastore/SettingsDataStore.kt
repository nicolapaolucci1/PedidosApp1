package com.example.controlepedidos.data.datastore


import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



val Context.dataStore by preferencesDataStore(
    name = "settings"
)



class SettingsDataStore(private val context: Context) {



    companion object {


        val USERNAME =
            stringPreferencesKey("username")


        val DARK_MODE =
            booleanPreferencesKey("dark_mode")


    }



    val username: Flow<String> =
        context.dataStore.data.map {


            it[USERNAME] ?: ""

        }



    val darkMode: Flow<Boolean> =
        context.dataStore.data.map {


            it[DARK_MODE] ?: false

        }



    suspend fun salvarUsername(value:String){


        context.dataStore.edit {


            it[USERNAME] = value

        }


    }



    suspend fun salvarDarkMode(value:Boolean){


        context.dataStore.edit {


            it[DARK_MODE] = value

        }


    }


}