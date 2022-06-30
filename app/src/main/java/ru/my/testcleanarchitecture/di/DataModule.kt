package ru.my.testcleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.my.testcleanarchitecture.data.repository.UserRepositoryImpl
import ru.my.testcleanarchitecture.data.storage.UserStorage
import ru.my.testcleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorage
import ru.my.testcleanarchitecture.domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context : Context) : UserStorage{
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return  UserRepositoryImpl(userStorage = userStorage)
    }


}