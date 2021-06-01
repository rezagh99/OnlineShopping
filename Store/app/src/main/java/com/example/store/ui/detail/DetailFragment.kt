package com.example.store.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.store.R
import com.example.store.model.entity.Product
import com.example.store.ui.about.AboutViewModel
import com.example.store.ui.home.HomeViewModel
private const val ARG_PARAM1 = "car_id"
private const val ARG_PARAM2 = "param2"
class DetailFragment : Fragment() {
    private var car_id: String? = null
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            car_id = it.getString(ARG_PARAM1)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailViewModel =
            ViewModelProvider(this).get(DetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        val img: ImageView = root.findViewById(R.id.image_product_detail)
        val name: TextView = root.findViewById(R.id.text_name_detail)
        val price: TextView = root.findViewById(R.id.text_price_detail)
        val leftNum: TextView = root.findViewById(R.id.text_leftNum_detail)
        val score: TextView = root.findViewById(R.id.text_score_detail)


        detailViewModel.selectedProduct.observe(viewLifecycleOwner, Observer {product->
            img.setImageResource(product.image)
            name.text=product.name
            price.text=product.price
            leftNum.text=product.leftNum
            score.text=product.score

        })
        return root
    }

    }
