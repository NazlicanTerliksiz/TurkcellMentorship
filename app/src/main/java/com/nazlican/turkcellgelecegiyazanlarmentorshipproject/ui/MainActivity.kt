package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.comman.viewBinding
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}