package com.example.homeworkfourteen.item

import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {

    var items = mutableListOf<Item>(
        Item(1, "Grocery list", "1) Apple  2) Banana  3) Chicken", "NOTE"),
        Item(2, "Lesson", "Information about generics in kotlin", "NOTE"),
        Item(3, "TBC Homework 14", "Homework due monday", "TASK"),
        Item(4, "Fight Club", "Don't talk about fight club", "NOTE"),
        Item(
            5,
            "Pride",
            "Love's gonna get you killed But pride’s gonna be the death of you and you and me",
            "NOTE"
        ),
        Item(4, "Do the loundary", "Do the loundary before 16:00", "TASK"),


        )
}