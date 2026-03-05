package com.example.day4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.day4.ui.theme.Day4Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etNim = findViewById<EditText>(R.id.etNim)
        val etNama = findViewById<EditText>(R.id.etNama)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)
        val rbKelas = findViewById<RadioGroup>(R.id.rbKelas)

        btnMasuk.setOnClickListener{
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val rbId = rbKelas.checkedRadioButtonId

            // Validasi NIM
            if (nim.isEmpty()){
                etNim.error = "NIM tidak boleh kosong"
                etNim.requestFocus()
                return@setOnClickListener
            }

            // Validasi Nama
            if (nama.isEmpty()){
                etNama.error = "Nama tidak boleh kosong"
                etNama.requestFocus()
                return@setOnClickListener
            }

            // Validasi Kelas
            if (rbId == -1){
                Toast.makeText(this, "Pilih kelas terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MenuActivity::class.java)
            if (rbId != -1){
                val radiobutton = findViewById<RadioButton>(rbId)
                val kelas = radiobutton.text.toString()
                intent.putExtra("KELAS",kelas)
            }


            intent.putExtra("NIM",nim)
            intent.putExtra("NAMA", nama)
            startActivity(intent)
        }
    }
}

