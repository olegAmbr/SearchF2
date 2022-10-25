package ru.devambrosov.searchf2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.devambrosov.searchf2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButtons()
    }


    private fun initButtons() {
        binding.button1.setOnClickListener {
             Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
        }
        binding.button3.setOnClickListener {
            Toast.makeText(this, "Категории", Toast.LENGTH_SHORT).show()
        }
        binding.button4.setOnClickListener {
            Toast.makeText(this, "Продолжить просмотр", Toast.LENGTH_SHORT).show()
        }
        binding.button5.setOnClickListener {
            Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
        }

    }


}