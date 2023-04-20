package edu.iest.ejerciciosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.iest.ejerciciosharedpreferences.adapter.VideojuegosAdapter
import edu.iest.ejerciciosharedpreferences.models.Videojuegos

class VideogamesActivity : AppCompatActivity() {
    private var recycler: RecyclerView? = null
    private var administradorDeLayouts: LinearLayoutManager? = null
    private var fabConfig: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videogames)
        fabConfig = findViewById(R.id.fabConfig)
        val juegos = Videojuegos().getVideogames()
        recycler = findViewById(R.id.recyclerJuegos)

        administradorDeLayouts = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        recycler?.layoutManager = administradorDeLayouts
        recycler?.adapter = VideojuegosAdapter(juegos, this)

        fabConfig?.setOnClickListener {
            val i = Intent(this@VideogamesActivity, DatosActivity::class.java)
            startActivity(i)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_images, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.options_menu_vertical) {
            Toast.makeText(this, "Option menu 1", Toast.LENGTH_LONG).show()
            recycler?.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
            return false
        }else if (item.itemId == R.id.option_menu_Horizontal) {
            Toast.makeText(this, "Option menu 2", Toast.LENGTH_LONG).show()
            recycler?.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false)
        }else if (item.itemId == R.id.options_menu_filas_dos) {
            Toast.makeText(this, "Option menu 3", Toast.LENGTH_LONG).show()
            recycler?.layoutManager = GridLayoutManager(this, 2)
        }else {
            Toast.makeText(this, "Option menu 4", Toast.LENGTH_LONG).show()
            recycler?.layoutManager = GridLayoutManager(this, 3)
        }

        return false
    }
}