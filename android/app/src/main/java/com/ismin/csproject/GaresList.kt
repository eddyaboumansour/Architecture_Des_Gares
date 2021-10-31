package com.ismin.csproject.fragments

import com.ismin.csproject.Gare

class GaresList {

    private val storage = HashMap<String, Gare>()

    fun addGare(aGare: Gare) {
        storage[aGare.titre] = aGare
    }

    fun getGare(titre: String): Gare? {
        return storage[titre]
    }

    fun getAllBooks(): ArrayList<Gare> {
        return ArrayList(storage.values.sortedBy { it.titre })
    }


    fun getTotalNumberOfGares(): Int {
        return storage.size;
    }

    fun clear() {
        storage.clear()
    }

}
