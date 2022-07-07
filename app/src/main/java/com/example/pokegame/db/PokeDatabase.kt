package com.example.pokegame.db

import android.content.Context
import androidx.room.*
import com.example.pokegame.models.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PokeDatabase : RoomDatabase() {

    abstract fun pokemonDao():PokeDao

    companion object {
        @Volatile
        private var instance: PokeDatabase? = null

        fun getInstance(context:Context) : PokeDatabase{
            synchronized(this){
                return instance?: Room.databaseBuilder(
                    context,
                    PokeDatabase::class.java,
                "pokemon_db.db"
                ).build().also {
                    instance = it
                }
            }
        }


    }

}