package com.example.androiddevchallenge.datasource

import com.example.androiddevchallenge.model.Puppy

class PuppiesRepository {
    private val puppies = listOf(
        Puppy(id = "1", "Max", 1, "puppy1.jpg"),
        Puppy(id = "2", "Charlie", 2, "puppy2.jpg"),
        Puppy(id = "3", "Cooper", 3, "puppy3.jpg"),
        Puppy(id = "4", "Buddy", 4, "puppy4.jpg"),
        Puppy(id = "5", "Jack", 5, "puppy5.jpg"),
        Puppy(id = "6", "Rocky", 1, "puppy6.jpg"),
        Puppy(id = "7", "Oliver", 2, "puppy7.jpg"),
        Puppy(id = "8", "Duke", 3, "puppy8.jpg"),
        Puppy(id = "9", "Tucker", 4, "puppy9.jpg"),
        Puppy(id = "10", "Bella", 5, "puppy10.jpg"),
    )

    fun getPuppies(): List<Puppy> {
        return puppies
    }

    fun getPuppy(id: String): Puppy? {
        return puppies.find { it.id == id }
    }
}