package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model

import com.google.gson.annotations.SerializedName

data class SimpsonModel(
    @SerializedName("quote")
    var quote: String?,
    @SerializedName("character")
    var character: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("characterDirection")
    var characterDirection: String?
)