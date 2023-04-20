package edu.iest.ejerciciosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    private var etEdad: EditText? = null
    private var etNombre: EditText? = null
    private var etAltura: EditText? = null
    private var etDinero: EditText? = null
    private var swConfig: Switch? = null
    private var bnAceptar: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarVistas()
        getDefaultConfig()
        bnAceptar?.setOnClickListener {
            val i = Intent(this@MainActivity, VideogamesActivity::class.java)

            if (swConfig?.isChecked() == true) {
                guardarConfiguracion()
                startActivity(i)
            }

            i.putExtra("NAME", etNombre?.text.toString())
            i.putExtra("ALTURA", etAltura?.text.toString().toFloat())
            i.putExtra("EDAD", etEdad?.text.toString().toInt())
            i.putExtra("DINERO", etDinero?.text.toString().toFloat())
            i.putExtra("PassedValues", true)
            startActivity(i)

        }
    }

    fun inicializarVistas() {
        etEdad = findViewById(R.id.etEdad)
        etNombre = findViewById(R.id.etName)
        etAltura  = findViewById(R.id.etAltura)
        etDinero = findViewById(R.id.etDinero)
        swConfig = findViewById(R.id.swConfiguracion)
        bnAceptar = findViewById(R.id.bnAceptarConfig)
    }

    fun guardarConfiguracion() {
        val preferencias = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)
        val editor = preferencias.edit()
        editor.putString("NAME", etNombre?.text.toString())
        editor.putFloat("ALTURA", etAltura?.text.toString().toFloat())
        editor.putInt("EDAD", etEdad?.text.toString().toInt())
        editor.putFloat("DINERO", etDinero?.text.toString().toFloat())
        editor.apply()
    }

    fun getDefaultConfig() {
        val preferencias = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)

        val name = preferencias?.getString("NAME", "").toString()
        val altura = preferencias?.getFloat("ALTURA", 0F)
        val edad = preferencias?.getInt("EDAD",0)
        val dinero =preferencias?.getFloat("DINERO", 0F)

        etNombre?.setText(name)

        if (edad == 0) {
            etEdad?.setText("")
        }else {
            etEdad?.setText(edad.toString())
        }

        if (altura == 0F) {
            etAltura?.setText("")
        }else {
            etAltura?.setText(altura.toString())
        }

        if (dinero == 0F) {
            etDinero?.setText("")
        }else {
            etDinero?.setText(dinero.toString())
        }
    }
}


