package com.ismin.csproject

import android.content.Context
import android.content.Intent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext


class GareAdapter(private val gares: ArrayList<Gare>,private val gareUpdater: GareUpdater): RecyclerView.Adapter<GareViewHolder>() {
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GareViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_gare, parent, false)
        context=parent.context

        return GareViewHolder(row)
    }



    override fun onBindViewHolder(holder: GareViewHolder, position: Int) {
        val (
            favoris,
            datasetid,
            recordid,
            date_de_numerisation,
            periode,
            lieux,
            origine_compagnie_sncf,
            sous_thematique,
            url_de_l_archive,
            lieux_de_conservation,
            coordx,
            coordy,
            thematique,
            date,
            legende,
            mots_cles_separe_par_une_virgule,
            cote_page,
            typologie,
            cote_sardo_reference,
            images,
            titre,
            description_technique_document_original,
            id,
            url_de_la_capture_d_ecran,
        ) = gares[position]

        holder.txvTitre.text = titre
        holder.txvPeriode.text = periode

        val httpsImages=images.replace("http","https")
        Picasso.get().load(httpsImages).into(holder.txvImage);

        holder.btnFavoris.setOnClickListener {

            gareUpdater.onGareUpdate(holder,gares[position],favoris)
        }

        toggleFavoris(holder,favoris)
        holder.itemView.setOnClickListener{
            val intent= Intent(context,GareDetails::class.java)
            intent.putExtra("iTitre",titre)
            intent.putExtra("iImage",httpsImages)
            intent.putExtra("iLegende",legende)
            intent.putExtra("iPeriode",periode)

            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return gares.size
    }


    fun toggleFavoris(holder: GareViewHolder,favoris:Boolean)
    {   var icon:Int
        if(favoris) {icon=R.drawable.ic_baseline_favorite_24}
        else {icon=R.drawable.ic_baseline_favorite_border_24}
        holder.btnFavoris.setImageDrawable(
            ContextCompat.getDrawable(context, icon));
    }

}