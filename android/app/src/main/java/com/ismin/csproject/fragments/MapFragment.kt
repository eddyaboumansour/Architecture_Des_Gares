package com.ismin.csproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ismin.csproject.GaresList
import com.ismin.csproject.R


class MapFragment : Fragment() {

lateinit var mapFragment: SupportMapFragment
lateinit var googleMap: GoogleMap
private val garesList= GaresList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_map, container, false)
        mapFragment= childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap=it
            garesList.getAllGares().forEach{it1->
                val location =LatLng(it1.coordx.toDouble(),it1.coordy.toDouble())
            googleMap.addMarker(MarkerOptions().position(location).title(it1.titre))
            }


        })
        return view
    }

}