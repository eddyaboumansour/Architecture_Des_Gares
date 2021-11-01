package com.ismin.csproject.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ismin.csproject.R
import org.w3c.dom.Text


class InfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_info, container, false)
        var introduction1= view.findViewById<TextView>(R.id.introduction)
        var liensVersDonnees= view.findViewById<TextView>(R.id.liensVersDonnees)
        var introduction2= view.findViewById<TextView>(R.id.introduction2)
        var txvGaresList= view.findViewById<TextView>(R.id.txvGaresList)
        var txvFavorites= view.findViewById<TextView>(R.id.txvFavorites)
        var txvFavoritesList= view.findViewById<TextView>(R.id.txvFavoritesList)
        var txvSearch= view.findViewById<TextView>(R.id.txvSearch)
        var txvLibraries= view.findViewById<TextView>(R.id.txvlibraries)
        var txvMapOverview=view.findViewById<TextView>(R.id.txvMapOverview)
        var txvMapDetail=view.findViewById<TextView>(R.id.txvMapDetail)


        introduction1.setText(
            Html.fromHtml("<h1>Introduction</h1>"+
                    "Cette application raconte l'histoire et la description des gares les plus importantes de france avant l'année 2000. elle affiche une liste d'éléments cliquables où vous pouvez apprécier plus de détails sur chaque gare.<br><br>" +
                    "Nous avons utilisé une donnée ouverte du site de la SNCF : ")
                )
        liensVersDonnees.setText("https://data.opendatasoft.com/api/records/1.0/search/?dataset=archives-sncf-new%40datasncf&q=&sort=-id&facet=thematique&facet=sous_thematique&refine.sous_thematique=Architecture+des+gares")

        introduction2.setText( Html.fromHtml("Nous n'avons pas utilisé toutes les informations dans les données JSON, nous avons seulement utilisé le titre de la gare, la photo, la période de temps et la légende de la photo.<br><br>"))



        txvGaresList.setText(
            Html.fromHtml("<h1>Liste des gares</h1>"+
            "Dessine la liste des gares dans une recyclerView qui affiche des éléments cliquables ainsi qu'une pagination lors du scrolling vers le bas, l'application ne charge pas toutes les données en même temps. elle les limite à 10 par page")

        )

        txvFavorites.setText(
            Html.fromHtml("<h1>Favoris</h1>"+
                    "Vous pouvez ajouter vos stations préférées à votre liste de favoris en cliquant sur le petit cœur à côté de l'élément gare comme indiqué ci-dessous")
        )

        txvFavoritesList.setText(
            Html.fromHtml("<h1>Liste des favoris</h1>"+
                    "Vous pouvez afficher cette liste de favoris en cliquant sur le cœur dans ActionBar pour afficher toutes vos gares préférées")
        )

        txvSearch.setText(
            Html.fromHtml("<h1>Recherche de données</h1>"+
                    "Vous pouvez également effectuer une recherche dans vos données en cliquant sur le bouton de recherche ci-dessus. À chaque fois que vous tapez, le gareService utilise l'API Get de votre backend pour générer des résultats en fonction de ce qui a été tapé.")
        )
        txvMapOverview.setText(
            Html.fromHtml("<h1>Google Maps Service</h1>"+
            "Vous pouvez trouver les positions des gares sur le service google map intégré dans l'application. Le service prend les coordonnées de la gare et les convertit en marqueur google map.")
        )

        txvMapDetail.setText(
            Html.fromHtml("Si vous cliquez sur un pin, vous pouvez obtenir le nom de la gare.")
        )


        txvLibraries.setText(
            Html.fromHtml("<h1>Librairies utilisées</h1>")
        )

        return view
    }

}