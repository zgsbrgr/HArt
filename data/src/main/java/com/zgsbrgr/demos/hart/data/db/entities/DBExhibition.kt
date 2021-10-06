package com.zgsbrgr.demos.hart.data.db.entities

import androidx.room.*

@Entity(
    tableName = "entities",
    indices = [
        Index(value = ["image_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = DBImage::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("image_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DBVenue::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("venue_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DBPoster::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("poster_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DBExhibition(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "image_id") val imageId: Long,
    @ColumnInfo(name = "begin_date") val beginDate: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "exhibition_id") val exhibitionId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "primary_image_url") val primaryImageUrl: String,
    @ColumnInfo(name = "temporal_order") val temporalOrder: Int,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "end_date") val endDate: String,
    @ColumnInfo(name = "venue_id") val venueId: Long,
    @ColumnInfo(name = "record_id") val recordId: Int,
    @ColumnInfo(name = "last_update") val lastUpdate: String,
    @ColumnInfo(name = "poster_id") val posterId: Long

)
