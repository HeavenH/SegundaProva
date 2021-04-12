package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprova.viewmodels.CadastraFragmentViewModel
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentCadastraBinding
import com.example.segundaprova.db.AppDatabase

class CadastraFragment : Fragment() {
  lateinit var viewModel: CadastraFragmentViewModel
  lateinit var binding: FragmentCadastraBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment

    viewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)

    binding.apply {
      btnCadastra.setOnClickListener {
        viewModel.name = cityName.text.toString()
        viewModel.description = cityDescription.text.toString()
        viewModel.population = cityPopulation.text.toString().toDouble()
        viewModel.size = citySize.text.toString()
        viewModel.pib = cityPib.text.toString().toInt()
        viewModel.capital = cityCapital.text.toString()

        viewModel.createGame()

        Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
      }

      return binding.root
    }
  }


}