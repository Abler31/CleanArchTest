package ru.my.testcleanarchitecture.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase
import ru.my.testcleanarchitecture.presentation.MainViewModelFactory

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context{
        return context
    }

    @Provides
    fun provideMainViewModelFactory(getUserNameUseCase: GetUserNameUseCase,
                                    saveUserNameUseCase: SaveUserNameUseCase
    ) : MainViewModelFactory{
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }
}