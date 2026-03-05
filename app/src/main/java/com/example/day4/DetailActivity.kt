package com.example.day4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNimDetail = findViewById<TextView>(R.id.tvNimDetail)
        val tvNamaDetail = findViewById<TextView>(R.id.tvNamaDetail)
        val tvKelasDetail = findViewById<TextView>(R.id.tvKelasDetail)
        val tvHargaDetail = findViewById<TextView>(R.id.tvHargaDetail)
        val tvMenuDetail = findViewById<TextView>(R.id.tvMenuDetail)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val etJumlah = findViewById<EditText>(R.id.etJumlah)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        val nim = intent.getStringExtra("NIM")
        val nama = intent.getStringExtra("NAMA")
        val kelas = intent.getStringExtra("KELAS")
        val menu = intent.getStringExtra("MENU")
        val harga = intent.getIntExtra("HARGA",0)

        tvNimDetail.text = "NIM: $nim"
        tvNamaDetail.text = "Nama: $nama"
        tvKelasDetail.text = "Kelas: $kelas"
        tvMenuDetail.text = "Menu Pilihan: $menu"
        tvHargaDetail.text = "Harga: Rp $harga"

        btnProses.setOnClickListener{
            val jumlahString = etJumlah.text.toString()

            if (jumlahString.isEmpty()){
                etJumlah.error = "Jumlah tidak boleh kosong"
                etJumlah.requestFocus()
                return@setOnClickListener
            }else{
                val jumlahInt = jumlahString.toInt()
                val total = harga * jumlahInt
                tvTotal.text = "Rp $total"
            }
        }
    }
}