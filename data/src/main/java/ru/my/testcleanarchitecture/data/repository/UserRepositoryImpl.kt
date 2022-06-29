package ru.my.testcleanarchitecture.data.repository

import ru.my.testcleanarchitecture.data.storage.models.User
import ru.my.testcleanarchitecture.data.storage.UserStorage
import ru.my.testcleanarchitecture.domain.models.SaveUsernameParam
import ru.my.testcleanarchitecture.domain.models.Username
import ru.my.testcleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository{

    override fun saveName(saveParam: SaveUsernameParam) : Boolean {
        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getName(): Username {
        val user = userStorage.get()
        val username = Username(firstName = user.firstName, lastName = user.lastName)
        return username
    }
}