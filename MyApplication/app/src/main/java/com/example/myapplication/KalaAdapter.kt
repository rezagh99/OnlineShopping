package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Kala
//import com.example.myapplication.DownloadImageFromInternet

class KalaAdapter(private var kala_list: List<Kala>, private val onItemClicked: (Int) -> Unit): RecyclerView.Adapter<KalaAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val kala_title: TextView
        val kala_company: TextView
       //val carImage: ImageView

        init {
            Log.i("TEST", "TEST: " + view)
            kala_title = view.findViewById(R.id.txt_title)
            kala_company = view.findViewById(R.id.txt_company)
           // carImage = view.findViewById(R.id.img_car)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kala_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kala_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kala: Kala = kala_list[position];
        holder.kala_title.text = kala.name
        holder.kala_company.text = kala.company.toString()
        //DownloadImageFromInternet(holder.carImage).execute(kala.image_path)
//        holder.itemView.setOnClickListener {
//            onItemClicked(position)
//        }
    }

    fun setKalaha(kalaha: List<Kala>){
        this.kala_list = kalaha;
        notifyDataSetChanged()
    }

}