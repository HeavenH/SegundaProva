package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprova.R
import com.example.segundaprova.databinding.FragmentAlteraBinding
import com.example.segundaprova.db.AppDatabase
import com.example.segundaprova.entity.CityEntity
import com.example.segundaprova.viewmodels.AlteraFragmentViewModel

class AlteraFragment : Fragment() {
  val database by lazy { AppDatabase.getDatabase(requireContext()) }

  lateinit var binding: FragmentAlteraBinding
  lateinit var alteraFragmentViewModel: AlteraFragmentViewModel;

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
    alteraFragmentViewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java);

    val args = AlteraFragmentArgs.fromBundle(requireArguments())

    alteraFragmentViewModel.getCity(args.idReq)

    binding.apply {
      updateName.setText(alteraFragmentViewModel.name)
      updateDescription.setText(alteraFragmentViewModel.description)
      updatePopulation.setText("" + alteraFragmentViewModel.population)
      updatePib.setText("" + alteraFragmentViewModel.pib)
      updateSize.setText(alteraFragmentViewModel.size)
      updateCapital.setText(alteraFragmentViewModel.capital)
      button2.setOnClickListener {
        alteraFragmentViewModel.name = updateName.text.toString();
        alteraFragmentViewModel.description = updateDescription.text.toString();

        var city = CityEntity(alteraFragmentViewModel.name, alteraFragmentViewModel.description,
                              alteraFragmentViewModel.population, alteraFragmentViewModel.pib,
                              alteraFragmentViewModel.size, alteraFragmentViewModel.capital);
        city.id = args.idReq
        alteraFragmentViewModel.AlteraDados(city)
        Navigation.findNavController(it).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
      }
    }

    // Inflate the layout for this fragment
    return binding.root;
  }


}