package ru.my.testcleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ru.my.testcleanarchitecture.R
import ru.my.testcleanarchitecture.app.App
import ru.my.testcleanarchitecture.data.repository.UserRepositoryImpl
import ru.my.testcleanarchitecture.data.storage.sharedPrefs.SharedPrefUserStorage
import ru.my.testcleanarchitecture.domain.usercase.GetUserNameUseCase
import ru.my.testcleanarchitecture.domain.usercase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory


    private val viewModel: MainViewModel by viewModels{vmFactory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        val getDataTextView = findViewById<TextView>(R.id.tv_getText)
        val getDataButton = findViewById<Button>(R.id.btn_getText)
        val passDataEditText = findViewById<EditText>(R.id.et_passText)
        val passDataButton = findViewById<Button>(R.id.btn_passText)

        viewModel.resultLiveData.observe(this, Observer {
            getDataTextView.text = it
        })

        getDataButton.setOnClickListener(View.OnClickListener {
            viewModel.load()
        })

        passDataButton.setOnClickListener(View.OnClickListener {
            val text: String = passDataEditText.text.toString()
            viewModel.save(text)
        })
    }
}