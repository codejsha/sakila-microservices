package com.example.app.catalog.domain.vo

enum class Category(val id: Int, val category: String) {
    NONE(0, "-"),
    ACTION(1, "Action"),
    ANIMATION(2, "Animation"),
    CHILDREN(3, "Children"),
    CLASSICS(4, "Classics"),
    COMEDY(5, "Comedy"),
    DOCUMENTARY(6, "Documentary"),
    DRAMA(7, "Drama"),
    FAMILY(8, "Family"),
    FOREIGN(9, "Foreign"),
    GAMES(10, "Games"),
    HORROR(11, "Horror"),
    MUSIC(12, "Music"),
    NEW(13, "New"),
    SCI_FI(14, "Sci-Fi"),
    SPORTS(15, "Sports"),
    TRAVEL(16, "Travel")
}

enum class MovieRating(val rating: String) {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17")
}

enum class Language(val id: Int, val language: String) {
    NONE(0, "-"),
    ENGLISH(1, "English"),
    ITALIAN(2, "Italian"),
    JAPANESE(3, "Japanese"),
    MANDARIN(4, "Mandarin"),
    FRENCH(5, "French"),
    GERMAN(6, "German")
}

enum class SpecialFeature(val feature: String) {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes")
}
