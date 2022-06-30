package ru.my.testcleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.my.testcleanarchitecture.data.repository.UserRepositoryImpl
import ru.my.testcleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorage
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            passUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}