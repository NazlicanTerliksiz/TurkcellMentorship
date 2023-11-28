package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.model.SimpsonModel
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.data.repo.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    private var _simpsonListLiveData = MutableLiveData<List<SimpsonModel>?>()
    val simpsonListLiveData: LiveData<List<SimpsonModel>?> get() = _simpsonListLiveData

    init {
        _simpsonListLiveData = homeRepository.simpsonListLiveData
    }

    fun getSimpsonCharacter() {
        homeRepository.getSimpsonCharacter()
    }

}