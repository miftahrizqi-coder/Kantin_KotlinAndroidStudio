package com.example.day4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val tvNimMenu = findViewById<TextView>(R.id.tvNimMenu)
        val tvNamaMenu = findViewById<TextView>(R.id.tvNamaMenu)
        val tvKelasMenu = findViewById<TextView>(R.id.tvKelasMenu)

        val btnNasiGoreng = findViewById<Button>(R.id.btnNasiGoreng)
        val btnAyamGeprek = findViewById<Button>(R.id.btnAyamGeprek)
        val btnMieAyam = findViewById<Button>(R.id.btnMieAyam)
        val btnSeblak = findViewById<Button>(R.id.btnSeblak)

        val nim = intent.getStringExtra("NIM")
        val nama = intent.getStringExtra("NAMA")
        val kelas = intent.getStringExtra("KELAS")

        tvNimMenu.text = "NIM: $nim"
        tvNamaMenu.text = "Nama: $nama"
        tvKelasMenu.text = "Kelas: $kelas"

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("NAMA", nama)
        intent.putExtra("NIM", nim)
        intent.putExtra("KELAS", kelas)

        btnNasiGoreng.setOnClickListener {
            val harga = 15000
            val nama = "Nasi Goreng"
            intent.putExtra("MENU", nama)
            intent.putExtra("HARGA", harga)

            startActivity(intent)
        }

        btnMieAyam.setOnClickListener {
            val harga = 12000
            val nama = "Mie Ayam"
            intent.putExtra("MENU", nama)
            intent.putExtra("HARGA", harga)

            startActivity(intent)
        }

        btnSeblak.setOnClickListener {
            val harga = 10000
            val nama = "Seblak"
            intent.putExtra("MENU", nama)
            intent.putExtra("HARGA", harga)

            startActivity(intent)
        }

        btnAyamGeprek.setOnClickListener {
            val harga = 18000
            val nama = "Ayam Geprek"
            intent.putExtra("MENU", nama)
            intent.putExtra("HARGA", harga)

            startActivity(intent)
        }

    }
}