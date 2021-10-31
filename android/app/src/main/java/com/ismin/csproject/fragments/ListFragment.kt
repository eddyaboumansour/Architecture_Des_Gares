package com.ismin.csproject.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismin.csproject.*
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

private const val ARG_GARES = "gares"


class ListFragment() : Fragment() {
    private lateinit var gareUpdater: GareUpdater
    private lateinit var gares: ArrayList<Gare>
    private lateinit var adapter : GareAdapter
    private lateinit var rcvGares:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val argGares = requireArguments().getSerializable(ARG_GARES) as ArrayList<Gare>?
        gares = argGares ?: ArrayList()

         adapter =GareAdapter(gares,gareUpdater)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is GareUpdater) {
            gareUpdater = context
        } else {
            throw RuntimeException("$context must implement MyActivityCallback")
        }
    }
    fun setGare(newgares:ArrayList<Gare>)
    {
            gares=newgares
            adapter=GareAdapter(gares,gareUpdater)
            rcvGares.adapter = adapter
            adapter.notifyDataSetChanged()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_list, container, false)
         rcvGares=view.findViewById(R.id.f_gares_list_rcv_gares)
         rcvGares.layoutManager = LinearLayoutManager(context)
         rcvGares.adapter = adapter


            return view;

    }


    companion object {

        @JvmStatic
        fun newInstance(gares: ArrayList<Gare>) =

            ListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_GARES, gares)


                }
            }
    }

}