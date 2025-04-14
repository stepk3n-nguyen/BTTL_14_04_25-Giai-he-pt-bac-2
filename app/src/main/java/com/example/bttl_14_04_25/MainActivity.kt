package com.example.bttl_14_04_25

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num_a : EditText = findViewById(R.id.ed_a)
        val num_b : EditText = findViewById(R.id.ed_b)
        val num_c : EditText = findViewById(R.id.ed_c)
        val tvResult : TextView = findViewById(R.id.tvResult)
        val btnSolve : Button = findViewById(R.id.btnSolve)
        btnSolve.setOnClickListener{
            val num_1 = num_a.text.toString().toDoubleOrNull()
            val num_2 = num_b.text.toString().toDoubleOrNull()
            val num_3 = num_c.text.toString().toDoubleOrNull()

            if (num_1 != null && num_2 != null && num_3 != null) {
                val delta = num_2*num_2 - 4*num_1*num_3
                if (delta != null) {
                    if (delta == 0.0) {
                        val x = -num_2 / (2 * num_1)
                        tvResult.text = "Phương trình có nghiệm kép: x = $x"
                    } else if (delta<0) {
                        tvResult.text = "Phuong trinh vo nghiem"
                    } else if (delta>0) {
                        val x1 = (-num_2 + Math.sqrt(delta)) / (2 * num_1)
                        val x2 = (-num_2 - Math.sqrt(delta)) / (2 * num_1)
                        tvResult.text = "Phuong trinh co 2 nghiem: x1 = $x1\n x2 = $x2"
                    }
                }

            }
        }
    }
}