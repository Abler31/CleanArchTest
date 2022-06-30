package ru.my.testcleanarchitecture.di

import dagger.Component
import ru.my.testcleanarchitecture.presentation.MainActivity

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

}