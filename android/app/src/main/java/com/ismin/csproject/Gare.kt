package com.ismin.csproject;
import java.io.Serializable;

data class Gare(
    var favoris:Boolean,
    val datasetid: String,
    val recordid:String,
    val date_de_numerisation:String,
    val periode:String,
    val lieux:String,
    val origine_compagnie_sncf:String,
    val sous_thematique:String,
    val url_de_l_archive:String,
    val lieux_de_conservation:String,
    val coordx:String,
    val coordy:String,
    val thematique: String,
    val date: String,
    val legende: String,
    val mots_cles_separe_par_une_virgule: String,
    val cote_page: String,
    val typologie: String,
    val cote_sardo_reference: String,
    val images: String,
    val titre: String,
    val description_technique_document_original: String,
    val id:String,
    val url_de_la_capture_d_ecran: String

): Serializable {}

