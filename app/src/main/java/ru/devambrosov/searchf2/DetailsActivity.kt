package ru.devambrosov.searchf2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.devambrosov.searchf2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        //Получаем наш фильм из переданного бандла
        val film = intent.extras?.get("film") as Film
        super.onCreate(savedInstanceState)
        setContentView(view)
        //Устанавливаем заголовок
        binding.detailsToolbar.title = film.title
//Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
//Устанавливаем описание
        binding.detailsDescription.text = film.description
    }
}