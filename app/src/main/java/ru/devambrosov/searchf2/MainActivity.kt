package ru.devambrosov.searchf2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import ru.devambrosov.searchf2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        initButtons()
    }


    private fun initButtons() {
        button1.SetOnClickListener {
             Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
        button2.SetOnClickListener {
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
        }
        button3.SetOnClickListener {
            Toast.makeText(this, "Категории", Toast.LENGTH_SHORT).show()
        }
        button4.SetOnClickListener {
            Toast.makeText(this, "Продолжить просмотр", Toast.LENGTH_SHORT).show()
        }
        button5.SetOnClickListener {
            Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
        }

    }


}