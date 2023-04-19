package edu.iest.ejerciciosharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.ejerciciosharedpreferences.adapter.VideojuegosAdapter
import edu.iest.ejerciciosharedpreferences.models.Videojuegos

class VideogamesActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videogames)

        val juegos = Videojuegos().getVideogames()
        recycler = findViewById(R.id.recyclerJuegos)
        val administradorDeLayouts = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        recycler?.layoutManager = administradorDeLayouts
        recycler?.adapter = VideojuegosAdapter(juegos, this)
    }
}