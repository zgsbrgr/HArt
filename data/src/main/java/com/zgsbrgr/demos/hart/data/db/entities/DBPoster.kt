package com.zgsbrgr.demos.hart.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "posters"
)
data class DBPoster(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "caption") val caption: String?
)
