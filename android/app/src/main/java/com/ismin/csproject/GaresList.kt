package com.ismin.csproject

class GaresList {

    private val storage = HashMap<String, Gare>()

    fun addGare(aGare: Gare) {
        storage[aGare.titre] = aGare
    }

    fun getGare(titre: String): Gare? {
        return storage[titre]
    }

    fun getAllGares(): ArrayList<Gare> {

        return ArrayList(storage.values.sortedBy { it.titre })
    }


    fun getTotalNumberOfGares(): Int {
        return storage.size
    }

    fun clear() {
        storage.clear()
    }

}
