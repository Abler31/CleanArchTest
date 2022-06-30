package ru.my.testcleanarchitecture.app

import android.app.Application
import ru.my.testcleanarchitecture.di.AppComponent
import ru.my.testcleanarchitecture.di.AppModule
import ru.my.testcleanarchitecture.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }
}