package com.nazlican.turkcellgelecegiyazanlarmentorshipproject.ui.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.R
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.comman.viewBinding
import com.nazlican.turkcellgelecegiyazanlarmentorshipproject.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var simpsonAdapter: SimpsonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSimpsonCharacter()
        mainSimpsonObserve()

    }
    private fun mainSimpsonObserve() {
        viewModel.simpsonListLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                simpsonAdapter = SimpsonAdapter(it)
                binding.rvCharacters.adapter = simpsonAdapter
                simpsonAdapter.notifyDataSetChanged()
            } else {
                Snackbar.make(requireView(), "liste boş", Snackbar.LENGTH_LONG).show()
                Log.d("nazli","liste bos")
            }
        }
    }
}