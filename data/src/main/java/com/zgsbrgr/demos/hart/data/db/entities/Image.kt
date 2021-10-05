package com.zgsbrgr.demos.hart.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "images"
)
data class Image(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "copyright") val copyRight: String,
    @ColumnInfo(name = "image_id") val imageId: Int,
    @ColumnInfo(name = "idsid") val idsid: Int,
    @ColumnInfo(name = "format") val format: String,
    @ColumnInfo(name = "caption") val caption: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "technique") val technique: String?,
    @ColumnInfo(name = "rendition_number") val renditionNumber: String,
    @ColumnInfo(name = "display_order") val displayOrder: Int,
    @ColumnInfo(name = "base_image_url") val baseImageUrl: String,
    @ColumnInfo(name = "alt_text") val altText: String?,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "width") val width: Int,
    @ColumnInfo(name = "iifbaseuri") val iifBaseUri: String

)
