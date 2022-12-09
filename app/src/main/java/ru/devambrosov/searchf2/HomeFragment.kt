@file:Suppress("UNREACHABLE_CODE", "DEPRECATION")

package ru.devambrosov.searchf2

import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.devambrosov.searchf2.databinding.FragmentHomeBinding
import ru.devambrosov.searchf2.databinding.MergeHomeScreenContentBinding
import java.util.*


class HomeFragment : Fragment() {
    private var _binding: MergeHomeScreenContentBinding? = null
    private  val binding get() = _binding!!

    private var _binding1: FragmentHomeBinding? = null
    private  val binding1 get() = _binding1!!

    private lateinit var filmsAdapter: FilmListRecyclerAdapter


    private val filmsDataBase = listOf(
        Film("Avengers", R.drawable.avengers1, "Cool blokbaster. The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe."),
        Film("Back to future", R.drawable.back_to_future, "Good fantastic film. Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown."),
        Film("Fight club", R.drawable.fight_club, "Thriller. An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."),
        Film("Joker", R.drawable.joker, "Drum. A mentally troubled stand-up comedian embarks on a downward spiral that leads to the creation of an iconic villain."),
        Film("The lord of the rings", R.drawable.lor, "Great fantasy. Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."),
        Film("One plus one", R.drawable.one_plus_one, "Heart-pearsing drum and comedy"),
        Film("The dark knight", R.drawable.the_dark_knight, "Blokbaster. When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = MergeHomeScreenContentBinding.inflate(inflater, container, false)
        _binding1 = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        return binding1.root

       //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scene = Scene.getSceneForLayout(binding1.homeFragmentRoot,
            R.layout.merge_home_screen_content, requireContext())
        //Создаем анимацию выезда поля поиска сверху
        val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)
//Создаем анимацию выезда RV снизу
        val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.main_recycler)
//Создаем экземпляр TransitionSet, который объединит все наши анимации
        val customTransition = TransitionSet().apply {
            //Устанавливаем время, за которое будет проходить анимация
            duration = 500
            //Добавляем сами анимации
            addTransition(recyclerSlide)
            addTransition(searchSlide)
        }
//Также запускаем через TransitionManager, но вторым параметром передаем нашу кастомную анимацию
        TransitionManager.go(scene, customTransition)



        //находим наш RV
        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutManager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запрос, и имя фильма приводить к нижнему регистру
                    it.title!!.lowercase(Locale.getDefault()).contains(newText.lowercase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })

    }

}
