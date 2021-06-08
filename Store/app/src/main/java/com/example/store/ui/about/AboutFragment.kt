package com.example.store.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.model.entity.Member
import com.example.store.model.repository.AboutDataRepository
import com.example.store.model.source.LocalDataBase
import com.example.store.ui.home.HomeViewModel
import com.example.store.ui.home.ProductAdapter

class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel

    private var member_id: Int = -1
    private lateinit var memberImage: ImageView
    private lateinit var memberName: TextView
    private lateinit var memberStu: TextView
    private lateinit var memberImage2: ImageView
    private lateinit var memberName2: TextView
    private lateinit var memberStu2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
        arguments?.let{member_id = it.getInt("member_id")}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
//    ):View?{
//        val view: View = inflater.inflate(R.layout.fragment_about, container, false)
//        memberImage = view.findViewById(R.id.image_mem)
//        memberName = view.findViewById(R.id.mem_name)
//        memberStu = view.findViewById(R.id.mem_stu)
//
//        val aboutDataRepository = AboutDataRepository.getMember()
//
//        val factory = AboutDataRepository.getMember()
//        val viewModel = ViewModelProvider(this,factory).get((AboutViewModel::class.java))
//        val member: Member = viewModel.getProduct(member_id)
//        memberName.text = member.name
//        memberStu.text = member.studentNumber
//        memberImage.setImageResource(member.image)
//    }
//}
    ): View? {
        aboutViewModel =
            ViewModelProvider(this).get(AboutViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_about, container, false)
        memberName = root.findViewById(R.id.mem_name)
        memberStu = root.findViewById(R.id.mem_stu)
        memberImage = root.findViewById(R.id.image_mem)
        memberName2 = root.findViewById(R.id.mem_name2)
        memberStu2 = root.findViewById(R.id.mem_stu2)
        memberImage2 = root.findViewById(R.id.image_mem2)
        //memberName2.text = root.findViewById(R.id.mem_name2)
        aboutViewModel.member1.observe(viewLifecycleOwner,{member1 ->
           // recyclerViewMember.adapter= AboutAdapter(members)
           memberName.text = member1.name
            memberStu.text = member1.studentNumber
            memberImage.setImageResource(member1.image)
        })

        aboutViewModel.member2.observe(viewLifecycleOwner, { member2 ->
           // recyclerViewMember.adapter = AboutAdapter(members)
            memberName2.text = member2.name
            memberStu2.text = member2.studentNumber
            memberImage2.setImageResource(member2.image)
       })
        return root
    }
}