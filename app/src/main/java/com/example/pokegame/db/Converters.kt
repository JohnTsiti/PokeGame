package com.example.pokegame.db

import androidx.room.TypeConverter
import com.example.pokegame.models.Sprites
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    var gson = Gson()

    @TypeConverter
    fun fromSprite(sprite: Sprites):String{
        return gson.toJson(sprite)
    }

    @TypeConverter
    fun toSprite(data : String) : Sprites{
        val type = object :TypeToken<Sprites>(){
        }.type
        return  gson.fromJson(data,type)
    }
}