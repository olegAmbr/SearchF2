package ru.devambrosov.searchf2.domain

import ru.devambrosov.searchf2.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}