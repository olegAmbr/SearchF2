package ru.devambrosov.searchf2.data

import ru.devambrosov.searchf2.R
import ru.devambrosov.searchf2.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film("Avengers",
            R.drawable.avengers1, "Cool blokbaster. The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.", 8.8f),
        Film("Back to future",
            R.drawable.back_to_future, "Good fantastic film. Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.",7.5f),
        Film("Fight club",
            R.drawable.fight_club, "Thriller. An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.", 6.5f),
        Film("Joker",
            R.drawable.joker, "Drum. A mentally troubled stand-up comedian embarks on a downward spiral that leads to the creation of an iconic villain.", 3.3f),
        Film("The lord of the rings",
            R.drawable.lor, "Great fantasy. Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", 5.5f),
        Film("One plus one", R.drawable.one_plus_one, "Heart-pearsing drum and comedy", 8.5f),
        Film("The dark knight",
            R.drawable.the_dark_knight, "Blokbaster. When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", 7.5f)
    )
}