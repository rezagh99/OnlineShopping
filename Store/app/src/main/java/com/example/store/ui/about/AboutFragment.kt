package com.example.store.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R

class AboutFragment : Fragment() {

    private lateinit var galleryViewModel: AboutViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(AboutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        //val recyclerViewMember: RecyclerView = root.findViewById(R.id.recycler_view_member)
//        galleryViewModel.members.observe(viewLifecycleOwner,{members ->
//            recyclerViewMember.adapter= AboutAdapter(members)
//        })
//        galleryViewModel.members.observe(viewLifecycleOwner, { members ->
//            recyclerViewMember.adapter = AboutAdapter(members)
//        })
        return root
    }
}