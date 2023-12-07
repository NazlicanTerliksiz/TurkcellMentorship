package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.source.remote

import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model.SimpsonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonsQuoteService {
    @GET("quotes?count=20")
    suspend fun getSimpson(): Response<List<SimpsonModel>>

    @GET("quotes")
    suspend fun getQuoteCharacter(
        @Query("character") character: String
    ): Response<List<SimpsonModel>>

}
