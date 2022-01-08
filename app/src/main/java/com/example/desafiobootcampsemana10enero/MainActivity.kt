package com.example.desafiobootcampsemana10enero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafiobootcampsemana10enero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var savedText = ""
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel:MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.mainViewModel = viewModel
        viewModel.savedTextLiveData.observe(this, {
            savedTextValue: String ->
            savedText = savedTextValue
            binding.savedText.text = "El texto guardado es: $savedTextValue"
        })

        binding.saveInfo.setOnClickListener {
            viewModel.saveText(binding.editSave.text.toString())
        }

        binding.launchActivity.setOnClickListener {
            openDetails(savedText)
        }
    }

    private fun openDetails(text: String) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(DetailedActivity.TEXT_KEY, text)
        startActivity(intent)
    }
}