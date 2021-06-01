package com.example.store.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.model.entity.Product
import com.example.store.R

class ProductRecyclerAdapter constructor(val onClickListener: OnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickListener {
        fun onClick(Product: Product)
    }

    private var items: List<Product> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false),
            onClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(ProductList: List<Product>) {
        this.items = ProductList
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ProductViewHolder constructor(
        itemView: View,
        val onClickListener: OnClickListener
    ) : RecyclerView.ViewHolder(itemView) {

       val product_name= itemView.findViewById<TextView>(R.id.text_name)
        val product_price= itemView.findViewById<TextView>(R.id.text_price)
        val product_img= itemView.findViewById<ImageView>(R.id.image_product)
        lateinit var product: Product

        init {
            itemView.setOnClickListener {
                onClickListener.onClick(product)
            }
        }

        fun bind(p: Product) {
            this.product = p
            product_name.setText(p.name)
            product_price.setText(p.price)
            product_img.setImageResource(p.image)
        }
    }
}