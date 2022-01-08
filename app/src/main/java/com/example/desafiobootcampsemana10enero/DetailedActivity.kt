package com.example.desafiobootcampsemana10enero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiobootcampsemana10enero.databinding.ActivityDetailedBinding
import com.example.desafiobootcampsemana10enero.databinding.ActivityMainBinding

class DetailedActivity : AppCompatActivity() {

    companion object{
        const val TEXT_KEY = "savedText"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val text = bundle.getString(TEXT_KEY)

        binding.finalText.text = "El texto cargado en la vista anterior fue: $text"
    }
}