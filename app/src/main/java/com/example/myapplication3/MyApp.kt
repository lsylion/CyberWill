package com.example.myapplication3

import android.app.Application
import androidx.databinding.library.BuildConfig
import androidx.room.Room
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.myapplication3.data.Answer
import com.example.myapplication3.data.AnswerRepository
import com.example.myapplication3.data.AppDatabase
import com.example.myapplication3.data.AppDatabaseCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MyApp : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { AnswerRepository(database.answerDao()) }



    override fun onCreate() {
        super.onCreate()

        /*CoroutineScope(Dispatchers.IO).launch {
            repository.insertAnswer(Answer(content = "你早已做出选择，请遵循内心", zodiacGroup = "Water", mbtiGroup = "INTJ"))
            repository.insertAnswer(Answer(content = "听从内心，别被外界干扰", zodiacGroup = "Water", mbtiGroup = "INTJ"))

        }*/

        // 初始化 Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // 使用Callback填充数据
        // 确保初始数据只会在数据库首次创建时被插入一次
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        )
            .addCallback(AppDatabaseCallback(this))
            .build()
    }
}