package ru.my.testcleanarchitecture.domain.usercase

import ru.my.testcleanarchitecture.domain.models.SaveUsernameParam
import ru.my.testcleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param : SaveUsernameParam) : Boolean{
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}