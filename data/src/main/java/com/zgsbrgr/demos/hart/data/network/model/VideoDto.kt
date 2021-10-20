package com.zgsbrgr.demos.hart.data.network.model


import com.google.gson.annotations.SerializedName
import com.zgsbrgr.demos.hart.domain.model.Video

data class VideoDto(
    @SerializedName("description")
    var description: String?,
    @SerializedName("primaryurl")
    var primaryurl: String?,
    @SerializedName("videoid")
    var videoid: Int
)

fun VideoDto.toVideo(): Video {
    return Video(
        description = description?:"",
        primaryUrl = primaryurl?:"",
        videoId = videoid
    )
}

fun List<VideoDto>.toVideoList(): List<Video> {
    return map { videoDto ->
        videoDto.toVideo()
    }
}