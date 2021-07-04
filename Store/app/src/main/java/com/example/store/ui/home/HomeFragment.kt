package com.example.store.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.entity.Product
import com.example.store.ui.detail.ProductRecyclerAdapter

class HomeFragment : Fragment() {


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var productAdapter: ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel.products.observe(viewLifecycleOwner,  { products->

            productAdapter.submitList(products)
        })

        val recyclerViewProduct: RecyclerView = root.findViewById(R.id.recycler_view_product)
        recyclerViewProduct.apply {
            layoutManager = LinearLayoutManager(context)
            productAdapter = ProductRecyclerAdapter(object : ProductRecyclerAdapter.OnClickListener{
                override fun onClick(product: Product) {
                    val navHostFragment =
                        (activity as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                    navHostFragment.navController.navigate(R.id.action_nav_home_to_nav_detail)
                }
            })
            adapter = productAdapter
            return root
        }

    }


}