package edu.iest.ejerciciosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DatosActivity : AppCompatActivity() {
    private var tvName: TextView? = null
    private var tvDinero: TextView? = null
    private var tvAltura: TextView? = null
    private var tvEdad: TextView? = null
    private var bnVolver: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        inicializarVistas()
        setText()

       bnVolver?.setOnClickListener {
           val i = Intent(this@DatosActivity, VideogamesActivity::class.java)
           startActivity(i)
       }
    }

    fun inicializarVistas() {
        tvName = findViewById(R.id.tvDatosName)
        tvDinero = findViewById(R.id.tvDatosDinero)
        tvEdad = findViewById(R.id.tvDatosEdad)
        tvAltura  = findViewById(R.id.tvDatosAltura)
        bnVolver = findViewById(R.id.bnDatosVolver)
    }

    fun setText() {
        val preferencias = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)
        val name = preferencias?.getString("NAME", "").toString()
        val altura = preferencias?.getFloat("ALTURA", 0F)
        val edad = preferencias?.getInt("EDAD",0)
        val dinero =preferencias?.getFloat("DINERO", 0F)

        tvName?.text = tvName?.text.toString() + name
        tvAltura?.text = tvAltura?.text.toString() + altura.toString()
        tvEdad?.text = tvEdad?.text.toString() + edad.toString()
        tvDinero?.text = tvDinero?.text.toString() + dinero.toString()
    }
}