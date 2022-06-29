package ru.my.testcleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.my.testcleanarchitecture.domain.models.SaveUsernameParam
import ru.my.testcleanarchitecture.domain.models.Username
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase : GetUserNameUseCase,
                    private val passUserNameUseCase: SaveUserNameUseCase) : ViewModel() {

    val resultLiveDataMutable = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultLiveDataMutable

    fun save(text : String){
        val resultData : Boolean = passUserNameUseCase.execute(param = SaveUsernameParam(text))
        resultLiveDataMutable.value = "$resultData"
    }
    fun load(){
        val username: Username = getUserNameUseCase.execute()
        resultLiveDataMutable.value = "${username.firstName} ${username.lastName}"
    }

}