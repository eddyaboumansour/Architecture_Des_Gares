package com.ismin.csproject

class Favoris(favoris: Boolean) {
    operator fun not(): Boolean {
        return !favoris
    }

    var favoris: Boolean = favoris

}