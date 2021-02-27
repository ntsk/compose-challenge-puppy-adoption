package com.example.androiddevchallenge.datasource

import com.example.androiddevchallenge.model.Puppy

class PuppiesRepository {
    private val puppies = listOf(
        Puppy(id = "1", "Max", 1),
        Puppy(id = "2", "Charlie", 2),
        Puppy(id = "3", "Cooper", 3),
        Puppy(id = "4", "Buddy", 4),
        Puppy(id = "5", "Jack", 5),
    )

    fun getPuppies(): List<Puppy> {
        return puppies
    }

    fun getPuppy(id: String): Puppy? {
        return puppies.find { it.id == id }
    }
}