package ru.devambrosov.searchf2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.devambrosov.searchf2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    val filmsDataBase = listOf(
        Film("Avengers", R.drawable.avengers1, "Cool blokbaster. The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe."),
        Film("Back to future", R.drawable.back_to_future, "Good fantastic film. Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown."),
        Film("Fight club", R.drawable.fight_club, "Thriller. An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."),
        Film("Joker", R.drawable.joker, "Drum. A mentally troubled stand-up comedian embarks on a downward spiral that leads to the creation of an iconic villain."),
        Film("The lord of the rings", R.drawable.lor, "Great fantasy. Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."),
        Film("One plus one", R.drawable.one_plus_one, "Heart-pearsing drum and comedy"),
        Film("The dark knight", R.drawable.avengers1, "Blokbaster. When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
       // val main_recycler = findViewById<RecyclerView>(R.id.main_recycler)
        setContentView(view)

        //находим наш RV
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    //Создаем бандл и кладем туда объект с данными фильма
                    val bundle = Bundle()
                    //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                    //передаваемый объект
                    bundle.putParcelable("film", film)
                    //Запускаем наше активити
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    //Прикрепляем бандл к интенту
                    intent.putExtras(bundle)
                    //Запускаем активити через интент
                    startActivity(intent)
                }
            })
            //Присваиваем адаптер
            binding.mainRecycler.adapter = filmsAdapter
            //Присвои layoutmanager
            binding.mainRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            binding.mainRecycler.addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)

        //val cardAnimation = AnimationUtils.loadAnimation(this, card_anim)
        //view.startAnimation(cardAnimation)

        //initCards()

        binding.topAppBarMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Категории", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Продолжить просмотр", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }






   /* private fun initCards() {
        binding.pirates.setOnClickListener {
             Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
        binding.monroe.setOnClickListener {
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
        }
        binding.friends.setOnClickListener {
            Toast.makeText(this, "Категории", Toast.LENGTH_SHORT).show()
        }
        binding.blackPanter.setOnClickListener {
            Toast.makeText(this, "Продолжить просмотр", Toast.LENGTH_SHORT).show()
        }

    } */


}