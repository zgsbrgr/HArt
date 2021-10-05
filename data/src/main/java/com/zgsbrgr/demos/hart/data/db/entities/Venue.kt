package com.zgsbrgr.demos.hart.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "venues"
)
data class Venue(
    @PrimaryKey(autoGenerate = true ) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "zipcode") val zipCode: String,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "begin_date") val beginDate: String,
    @ColumnInfo(name = "end_date") val endDate: String?,
    @ColumnInfo(name = "secondary_address") val secondaryAddress: String?,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "primary_address") val primaryAddress: String,
    @ColumnInfo(name = "venue_id") val venueId: Long,
    @ColumnInfo(name = "is_ham_venue") val isHamVenue: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "state") val state: String
)
