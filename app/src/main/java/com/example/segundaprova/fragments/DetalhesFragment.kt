package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentDetalhesBinding
import com.example.segundaprova.viewmodels.AlteraFragmentViewModel
import com.example.segundaprova.viewmodels.DetalhesFragmentViewModel


class DetalhesFragment : Fragment() {

  lateinit var binding: FragmentDetalhesBinding
  lateinit var detalhesFragmentViewModel: DetalhesFragmentViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
    detalhesFragmentViewModel = ViewModelProvider(this).get(DetalhesFragmentViewModel::class.java);

    val args = DetalhesFragmentArgs.fromBundle(requireArguments())

    detalhesFragmentViewModel.getCity(args.reqId)

    binding.apply {
      textName.setText(detalhesFragmentViewModel.name)
      textDescription.setText(detalhesFragmentViewModel.description)
      textPopulation.setText("" + detalhesFragmentViewModel.population)
      textPib.setText("" + detalhesFragmentViewModel.pib)
      textSize.setText(detalhesFragmentViewModel.size)
      textCapital.setText(detalhesFragmentViewModel.capital)
    }

    // Inflate the layout for this fragment
    return binding.root
  }
}