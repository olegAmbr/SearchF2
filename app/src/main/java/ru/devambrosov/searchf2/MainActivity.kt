package ru.devambrosov.searchf2

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Animation.AnimationListener
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.devambrosov.searchf2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val cardAnimation = AnimationUtils.loadAnimation(this, R.anim.)
        view.startAnimation(cardAnimation)
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