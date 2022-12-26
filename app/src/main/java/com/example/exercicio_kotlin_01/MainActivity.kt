package com.example.exercicio_kotlin_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.exercicio_kotlin_01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chargeTextView()
        viewBinding()
    }

    private fun viewBinding () {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun chargeTextView() {
        val list = listOf( "Bruno", "Caio", "Paulo")
        var currentItemIndex = 0

        binding.BotaoNext.setOnClickListener() {
            if (currentItemIndex >= list.size) {
                currentItemIndex = 0
            }
            binding.textView.text = list [currentItemIndex]
            currentItemIndex++
        }

    }

}