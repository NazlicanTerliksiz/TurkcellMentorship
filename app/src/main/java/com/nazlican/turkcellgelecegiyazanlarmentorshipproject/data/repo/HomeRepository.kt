package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.repo

import androidx.lifecycle.MutableLiveData
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model.SimpsonModel
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.source.remote.SimpsonsQuoteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val simpsonsQuoteService: SimpsonsQuoteService) {

    var simpsonListLiveData = MutableLiveData<List<SimpsonModel>?>()

    fun getSimpsonCharacter(){
        CoroutineScope(Dispatchers.IO).launch {
            CoroutineScope(Dispatchers.IO).launch{
                val response = simpsonsQuoteService.getSimpson()
                withContext(Dispatchers.Main){
                    if (response?.isSuccessful == true){
                        simpsonListLiveData.value = response.body()
                    }
                }
            }
        }
    }
}