package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.domain

import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model.SimpsonModel
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.source.remote.SimpsonsQuoteService
import javax.inject.Inject

class SimpsonUsecase @Inject constructor(private val simpsonsQuoteService: SimpsonsQuoteService) {

    suspend fun getSimpsonCharacterUsecase(): List<SimpsonModel>? {
        return try {
            val response = simpsonsQuoteService.getSimpson()
            if (response.isSuccessful) {
                response.body()
            } else
                null
        } catch (e: Exception) {
            null
        }
    }



}