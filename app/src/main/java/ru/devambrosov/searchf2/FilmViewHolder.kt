package ru.devambrosov.searchf2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.devambrosov.searchf2.databinding.FilmItemBinding

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = FilmItemBinding.bind(itemView)
    //Привязываем View из layout к переменным
    //private val title = binding.itemView.title
   // private val poster = binding.itemView.poster
   // private val description = binding.itemView.description

    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        binding.title.text = film.title
        //Устанавливаем постер
        binding.poster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.description.text = film.description
    }
}