package com.ismin.csproject

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GareViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {

    var txvTitre = rootView.findViewById<TextView>(R.id.r_gare_titre)
    var txvPeriode = rootView.findViewById<TextView>(R.id.r_gare_periode)
    var txvImage = rootView.findViewById<ImageView>(R.id.r_gare_image)
    var btnFavoris = rootView.findViewById<ImageButton>(R.id.r_gare_favoris)
}