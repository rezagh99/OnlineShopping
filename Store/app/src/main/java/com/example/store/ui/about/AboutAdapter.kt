package com.example.store.ui.about

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.model.entity.Member
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.store.R

class AboutAdapter(private var member_list: List<Member>): RecyclerView.Adapter<AboutAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val member_name: TextView
        val member_stu: TextView
        val member_img: ImageView

        init {
            member_name = view.findViewById(R.id.mem_name)
            member_stu = view.findViewById(R.id.mem_stu)
            member_img = view.findViewById(R.id.image_mem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_about, parent, false)
        //val view=TextView(parent.context)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return member_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Member = member_list[position];
        holder.member_name.text = user.name
        holder.member_stu.text =user.studentNumber
        //holder.product_img.src=kala.image
    }

    fun setMembers(members: List<Member>){
        this.member_list = members;
        notifyDataSetChanged()
    }
}