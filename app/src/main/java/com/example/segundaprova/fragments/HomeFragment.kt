package com.example.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprova.*
import com.example.segundaprova.databinding.FragmentHomeBinding
import com.example.segundaprova.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewmodel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.apply {
            fab.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
            }

        }

        viewmodel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = CityAdapter()
        binding.recyclerView.adapter = adapter

        viewmodel.list.observe(viewLifecycleOwner, {
            adapter.cities = it
            adapter.notifyDataSetChanged()
        })

        binding.recyclerView.addOnItemTouchListener(
            RecyclerViewClickListener(requireContext(), binding.recyclerView,
            object : RecyclerViewClickListener.onItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    Navigation.findNavController(v).navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(
                        adapter.cities[position].id
                    )
                    )
                }

                override fun onItemLongClick(v: View, position: Int) {
                    Navigation.findNavController(v).navigate(
                        HomeFragmentDirections.actionHomeFragmentToAlteraFragment(
                        adapter.cities[position].id
                    )
                    )
                }

            })
        )

        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = layout

        return binding.root
    }


}