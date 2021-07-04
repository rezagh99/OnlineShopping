package com.example.store.ui.home
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.entity.Product

class ProductAdapter(private var product_list: List<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val product_name: TextView
        val product_price: TextView
        val product_img: ImageView
        val product_leftNum: TextView

        init {
            product_name = view.findViewById(R.id.text_name)
            product_price = view.findViewById(R.id.text_price)
            product_img = view.findViewById(R.id.image_product)
           product_leftNum=view.findViewById(R.id.text_leftNum_detail)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false
        )
        //val view=TextView(parent.context)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return product_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kala: Product = product_list[position];
        holder.product_name.text = "Product Name:"+kala.name
        holder.product_price.text ="Product Price:"+ kala.price
        holder.product_img.setImageResource(kala.image)
    }

    fun setKalaha(products: List<Product>){
        this.product_list = products;
        notifyDataSetChanged()
    }



}


