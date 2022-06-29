package ru.my.testcleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.my.testcleanarchitecture.data.repository.UserRepositoryImpl
import ru.my.testcleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorage
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    val repository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context = context)) }
    val getUserNameUseCase by lazy { GetUserNameUseCase(repository) }
    val passUserNameUseCase by lazy { SaveUserNameUseCase(repository) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            passUserNameUseCase = passUserNameUseCase
        ) as T
    }
}