package com.app.poegr2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_statistics)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var etNumber = findViewById<EditText>(R.id.etNumber).text
        var btnAdd = findViewById<Button>(R.id.btnFillArray)
        var tvResultStat = findViewById<TextView>(R.id.tvResultStat)
        var btnClear = findViewById<Button>(R.id.btnClear)
        var btnCalcAvg = findViewById<Button>(R.id.btnAvg)
        var btnMinMax = findViewById<Button>(R.id.btnMinMax)
        var tvResultFinal = findViewById<TextView>(R.id.tvResultFinal)

//        var numbers = arrayOf<Int>(2, 3, 45, 67, 70, 10, 30)
        var integers = IntArray(10)
        var counter = 0

        //Created object
        var helper = StatisticsHelper()

        btnAdd.setOnClickListener {

            if (counter > 9) {
                tvResultStat.text = "Error::No more than 10 elements"
            } else {
                var input = etNumber.toString().toInt()
                integers[counter] = input
                counter++
                var result = helper.displayArrayValues(integers)
                tvResultStat.text = result
            }
        }

        btnClear.setOnClickListener {
            helper.clearArrayValues(integers)
            tvResultStat.text = ""
            counter = 0
        }

        btnCalcAvg.setOnClickListener {
            var avg = helper.calculateAvg(integers)
            tvResultFinal.text = "The average is $avg"
        }

        btnMinMax.setOnClickListener {
            var min = helper.findMin(integers)
            var max = helper.findMax(integers)

            tvResultFinal.text = "The min is $min and the max is $max"
        }
    }
}