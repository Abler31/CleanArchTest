package ru.my.testcleanarchitecture.domain.repository

import ru.my.testcleanarchitecture.domain.models.SaveUsernameParam
import ru.my.testcleanarchitecture.domain.models.Username

interface UserRepository {

    fun saveName(saveParam: SaveUsernameParam) : Boolean

    fun getName() : Username
}