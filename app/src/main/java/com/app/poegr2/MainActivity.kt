package com.app.poegr2

import android.content.Intent
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNumber1 = findViewById<EditText>(R.id.etNumber1).text
        val etNumber2 = findViewById<EditText>(R.id.etNumber2).text

        var numbers = arrayOf<Int>(1, 2, 4, 7)
        var names = arrayOf<String>("Steven", "Lerato", "Boujie", "Name")


        var integers = IntArray(5)

        integers[0] = 15
        integers[1] = 10
        integers[2] = 12
        integers[3] = 14

        val btnAdd = findViewById<Button>(R.id.btnFillArray)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMultiply = findViewById<Button>(R.id.btnMulti)
        val btnDivide = findViewById<Button>(R.id.btnDiv)
        val btnSqrt = findViewById<Button>(R.id.btnSqrt)
        val btnPow = findViewById<Button>(R.id.btnPow)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnStat = findViewById<Button>(R.id.btnStat)

        btnAdd.setOnClickListener {
            val number1 = etNumber1.toString().toInt()
            val number2 = etNumber2.toString().toInt()

            val result = number1 + number2

            tvResult.text = "$number1 + $number2 = $result"
        }

        btnSub.setOnClickListener {
            val number1 = etNumber1.toString().toInt()
            val number2 = etNumber2.toString().toInt()

            val result = number1 - number2

            tvResult.text = "$number1 - $number2 = $result"
        }

        btnMultiply.setOnClickListener {
            val number1 = etNumber1.toString().toInt()
            val number2 = etNumber2.toString().toInt()

            val result = number1 * number2

            tvResult.text = "$number1 * $number2 = $result"
        }


        btnDivide.setOnClickListener {
            val number1 = etNumber1.toString().toInt()
            val number2 = etNumber2.toString().toInt()

            if (number2 == 0) {
                tvResult.text = "Division by ZERO is not allowed"
            } else {
                val result = number1 / number2
                tvResult.text = "$number1 / $number2 = $result"
            }
        }

        btnSqrt.setOnClickListener {
            var number1 = etNumber1.toString().toDouble()

            if (number1 < 0) {
                var abs = number1 * -1
                var result = Math.sqrt(abs)

                tvResult.text = "sqrt($number1) = $result i"
            } else {
                var result = Math.sqrt(number1)
                tvResult.text = "sqrt($number1) = $result"
            }
        }

        btnPow.setOnClickListener {
            val number1 = etNumber1.toString().toInt()
            val number2 = etNumber2.toString().toInt()

//            var r = Math.pow(number1.toDouble(), number2.toDouble())

            var counter = 1
            var result = 1

            while (counter <= number2) {
                result *= number1
                counter++
            }

            tvResult.text = "$number1 ^ $number2 = $result"
        }

        btnStat.setOnClickListener {
            var intent = Intent(this, Statistics::class.java)
            startActivity(intent)
        }
    }
}