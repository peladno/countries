package com.example.paises

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.paises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Lista de países de Sudamérica
    private val countries = listOf(
        "Argentina",
        "Bolivia",
        "Brasil",
        "Chile",
        "Colombia",
        "Ecuador",
        "Guyana",
        "Paraguay",
        "Perú",
        "Surinam",
        "Uruguay",
        "Venezuela"
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val textView = binding.tv1
        val listView = binding.list1

        textView.text = getString(R.string.select_country)

        // Adaptador para la lista de países
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        listView.adapter = adapter

        // Agregar un listener para cuando se seleccione un país
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedCountry = countries[position]
            val population = obtenerPoblacion(selectedCountry)
            textView.text = "Habitantes de $selectedCountry: $population millones"
        }
    }

    // Función para obtener la población de los países
    private fun obtenerPoblacion(pais: String): Double {
        return when (pais) {
            "Argentina" -> 45.38
            "Bolivia" -> 11.51
            "Brasil" -> 212.56
            "Chile" -> 19.46
            "Colombia" -> 50.88
            "Ecuador" -> 17.37
            "Guyana" -> 0.78
            "Paraguay" -> 7.28
            "Perú" -> 32.17
            "Surinam" -> 0.58
            "Uruguay" -> 3.51
            "Venezuela" -> 28.52
            else -> 0.0
        }
    }
}
