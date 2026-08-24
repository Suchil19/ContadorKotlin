package com.example.myapplicationb01

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplicationb01.databinding.ActivityMainBinding
// NO toques los imports de arriba, déjalos como están

class MainActivity : AppCompatActivity() {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Usamos la ruta completa del paquete para evitar agregar imports
        val tvContador = findViewById<android.widget.TextView>(R.id.tvContador)
        val btnIncrementar = findViewById<android.widget.Button>(R.id.btnIncrementar)
        val btnReset = findViewById<android.widget.Button>(R.id.btnReset)

        // Incrementar valor
        btnIncrementar.setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }

        // Reiniciar valor
        btnReset.setOnClickListener {
            contador = 0
            tvContador.text = "0"
        }
    }
}