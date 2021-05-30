package com.example.myapplication


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.KalaAdapter
import com.example.myapplication.Kala
import com.example.myapplication.InterUtil
import com.example.myapplication.KalaViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {
    private lateinit var list_Kala: RecyclerView
    private lateinit var btnAbout: Button
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        list_Kala = view.findViewById(R.id.list_kala)
        btnAbout = view.findViewById(R.id.btn_about)


        val kala_list: List<Kala> = emptyList();
        val factory = InterUtil.provideKalaViewModelStore()
        val viewModel = ViewModelProvider(this, factory).get(KalaViewModel::class.java)
        list_Kala.layoutManager = LinearLayoutManager(context)
        list_Kala.adapter = KalaAdapter(kala_list) {
            Log.i("TEST", "Item " + it + " Clicked")
            val Description = Description();
            val bundle: Bundle = Bundle();
            Description.arguments = bundle;

            bundle.putInt("kala_id", it);
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null) {
                transaction.replace(R.id.nav_host_fragment, Description)
                transaction.addToBackStack(null)
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                transaction.commit()
            }
        };

        viewModel.getKalaha().observe(viewLifecycleOwner, Observer { kalaha ->
            if (kalaha != null) {
                if (list_Kala.adapter != null)
                    (list_Kala.adapter as KalaAdapter).setKalaha(kalaha = kalaha)
            }
        });

        btnAbout.setOnClickListener {
            Log.i("TEST", "About Us Clicked!")

            val aboutUsFragment = AboutUs();
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            if (transaction != null) {
                transaction.replace(R.id.nav_host_fragment, aboutUsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }

        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}