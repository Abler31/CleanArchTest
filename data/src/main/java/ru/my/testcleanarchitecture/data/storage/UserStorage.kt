package ru.my.testcleanarchitecture.data.storage


import ru.my.testcleanarchitecture.data.storage.models.User

interface UserStorage {
    fun save(user : User) : Boolean

    fun get(): User

}