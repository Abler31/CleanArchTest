package ru.my.testcleanarchitecture.domain.usercase

import ru.my.testcleanarchitecture.domain.models.Username
import ru.my.testcleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute() : Username{
        return repository.getName()
    }
}