package com.example.store.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerViewProduct: RecyclerView = root.findViewById(R.id.recycler_view_product)
        homeViewModel.products.observe(viewLifecycleOwner,{products ->
            recyclerViewProduct.adapter=ProductAdapter(products)})

        homeViewModel.products.observe(viewLifecycleOwner, { products ->
            recyclerViewProduct.adapter = ProductAdapter(products)
        })




        // val textView: TextView = root.findViewById(R.id.text_home)
      //  homeViewModel.text.observe(viewLifecycleOwner, Observer {
      //      textView.text = it
       // })
        return root
    }
}