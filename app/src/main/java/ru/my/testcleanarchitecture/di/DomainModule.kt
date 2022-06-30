package ru.my.testcleanarchitecture.di

import dagger.Module
import dagger.Provides
import ru.my.testcleanarchitecture.domain.repository.UserRepository
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase{
        return GetUserNameUseCase(repository = userRepository)
    }

    @Provides
    fun providePassUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}