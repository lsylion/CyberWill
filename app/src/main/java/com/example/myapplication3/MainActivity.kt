package com.example.myapplication3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication3.data.AnswerDao
import com.example.myapplication3.data.AnswerRepository

import com.example.myapplication3.ui.screen.FirstScreen
import com.example.myapplication3.ui.screen.SecondScreen
import com.example.myapplication3.ui.theme.MyApplication3Theme
import com.example.myapplication3.ui.viewModel.AnswerViewModel
import com.example.myapplication3.ui.viewModel.AnswerViewModelFactory
import timber.log.Timber

class MainActivity : ComponentActivity() {
    private lateinit var repository: AnswerRepository
    private lateinit var viewModel: AnswerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("MainActivity onCreate")
        try {
            enableEdgeToEdge()
            repository = (application as MyApp).repository
            viewModel = AnswerViewModel(repository)

            setContent {
                @Composable
                fun MainActivityContent() {
                    MyApplication3Theme {
                        val navController = rememberNavController()

                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            NavHost(
                                navController = navController,
                                startDestination = "first",
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                composable("first") {
                                    FirstScreen(
                                        navController = navController,
                                        viewModel = viewModel
                                    )
                                }
                                composable("second") {
                                    SecondScreen(
                                        navController = navController,
                                        viewModel = viewModel
                                    )
                                }
                            }
                        }
                    }
                }
                MainActivityContent()
            }
        } catch (e: Exception) {
            Timber.e(e, "Error in onCreate")
        }
    }
}

