package com.ismin.csproject

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.squareup.picasso.Picasso

class GareDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gare_details)
        var txvImage  = findViewById<ImageView>(R.id.d_gare_image)
        var txvPeriode = findViewById<TextView>(R.id.d_gare_periode)
        var txvLegende = findViewById<TextView>(R.id.d_gare_legende)
        val actionBar: ActionBar?=supportActionBar
        var intent=intent
        val dTitre=intent.getStringExtra("iTitre")
        val dImage=intent.getStringExtra("iImage")
        val dLegende=intent.getStringExtra("iLegende")
        val dPeriode=intent.getStringExtra("iPeriode")


        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setHomeButtonEnabled(true)
            actionBar.setTitle(dTitre)
        }

        Picasso.get().load(dImage).into(txvImage);
        txvLegende.text=dLegende
        txvPeriode.text=dPeriode

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}