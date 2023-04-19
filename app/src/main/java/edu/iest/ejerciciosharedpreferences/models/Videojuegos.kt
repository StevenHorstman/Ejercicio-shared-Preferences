package edu.iest.ejerciciosharedpreferences.models

import edu.iest.ejerciciosharedpreferences.R

class Videojuegos {
    fun getVideogames(): ArrayList<Videogame>{
        var videogames: ArrayList<Videogame>
        videogames= arrayListOf()

        videogames.add(
            Videogame(1, "Starcraft 2", 700F,
                "PC", "R",R.drawable.sc2))

        videogames.add(
            Videogame(1, "Civilization 6", 500F, "PC", "T",
                R.drawable.civ6))

        videogames.add(
            Videogame(3, "Quake 3", 100F, "PC",
                "R", R.drawable.q3)
        )

        videogames.add(Videogame(4, "Supermario Galaxy 2", 250F,
            "Wii", "E+", R.drawable.supermariogalaxy2))

        videogames.add(Videogame(5, "Warcraft 3: Reforged", 450F,
            "PC", "T", R.drawable.wx3))

        videogames.add(Videogame(6, "Bioshock Infinite", 500F,
            "PC", "R", R.drawable.bs3))

        videogames.add(Videogame(7, "Devil May Cry: HD Collection", 460F,
            "PC", "R", R.drawable.bs3))

        return videogames
    }
}