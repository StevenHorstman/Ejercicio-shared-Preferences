package edu.iest.ejerciciosharedpreferences.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.ejerciciosharedpreferences.R
import edu.iest.ejerciciosharedpreferences.models.Videogame

class VideojuegosAdapter(videogames: ArrayList<Videogame>, context: Context):
    RecyclerView.Adapter<VideojuegosAdapter.ContenedorDeVista>() {
    var innerVideogames: ArrayList<Videogame> = videogames
    var innerContext: Context = context
    val preferencias = context.getSharedPreferences("PREFERENCIAS", AppCompatActivity.MODE_PRIVATE)

    // Siempre tiene que tener de argumentro vista
    // Hereda lo de RecyclerView.ViewHolder
    inner class ContenedorDeVista(view: View): RecyclerView.ViewHolder(view){
        val tvNombreJuego: TextView
        val tvPrecio: TextView
        val ivFoto: ImageView
        val tvConsola: TextView
        val bnGuardar: Button
        val tvClasificacion: TextView
        val edad = preferencias.getInt("EDAD", 0)


        init {
            // Aqui haremos el inflate del layout
            tvNombreJuego  = view.findViewById(R.id.tvNombreJuego)
            tvPrecio = view.findViewById(R.id.tvCosto)
            ivFoto = view.findViewById(R.id.ivJuego)
            tvConsola = view.findViewById(R.id.tvConsola)
            bnGuardar = view.findViewById(R.id.bnComprar)
            tvClasificacion = view.findViewById(R.id.tvClasificacion)

            bnGuardar.setOnClickListener { v: View ->
                if (tvClasificacion.text.toString() == "E+") {
                    Toast.makeText(bnGuardar.context, "Comprado", Toast.LENGTH_LONG).show()

                }else if (tvClasificacion.text.toString() == "T") {
                    if (edad >= 5) {
                        Toast.makeText(bnGuardar.context, "Comprado", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(
                            bnGuardar.context,
                            "No cumple con lols requisitos de edad",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }else if (tvClasificacion.text.toString() == "R") {
                    if (edad >= 18) {
                        Toast.makeText(bnGuardar.context, "Comprado", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(
                            bnGuardar.context,
                            "No cumple con lols requisitos de edad",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_juego, parent, false)

        return  ContenedorDeVista(view)
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val videojuego: Videogame = innerVideogames.get(position)
        holder.tvNombreJuego.text = videojuego.nombre
        holder.tvPrecio.text = videojuego.precio.toString()
        holder.tvConsola.text = videojuego.consola
        holder.ivFoto.setImageResource(videojuego.imagen)
        holder.tvClasificacion.text  = videojuego.clasificacion
    }


    override fun getItemCount(): Int {
        return innerVideogames.size //El size te la cantidad de elementos que hay en ele arraylist
    }
}
