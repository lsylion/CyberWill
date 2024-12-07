package com.example.myapplication3.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication3.data.AnswerRepository

class AnswerViewModelFactory(
    private val repository: AnswerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnswerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnswerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}