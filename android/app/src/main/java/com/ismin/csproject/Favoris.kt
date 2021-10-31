package com.ismin.csproject

class Favoris(favoris: Boolean) {
    operator fun not(): Boolean {

        return !favoris
    }

    private var favoris:Boolean=favoris


}