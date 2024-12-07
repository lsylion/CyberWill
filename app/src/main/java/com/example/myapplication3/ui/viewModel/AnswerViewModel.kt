package com.example.myapplication3.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication3.data.Answer
import com.example.myapplication3.data.AnswerRepository
import kotlinx.coroutines.launch

class AnswerViewModel(
    private val repository: AnswerRepository
) : ViewModel() {
    private val _answers = MutableLiveData<List<Answer>>()
    val answers: LiveData<List<Answer>> = _answers

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _selectedZodiac = MutableLiveData("Water")
    val selectedZodiac: LiveData<String> = _selectedZodiac

    private val _selectedMBTI = MutableLiveData("INTJ")
    val selectedMBTI: LiveData<String> = _selectedMBTI

    private val _randomButtonClickCount = MutableLiveData<Int>(0)
    val randomButtonClickCount: LiveData<Int> = _randomButtonClickCount

    fun fetchAnswers(zodiacGroup: String, mbtiGroup: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _answers.value = repository.getAllAnswersByGroups(zodiacGroup, mbtiGroup)
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
                _answers.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchRandomAnswer(zodiacGroup: String, mbtiGroup: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val randomAnswer = repository.getRandomAnswer(zodiacGroup, mbtiGroup)
                _answers.value = if (randomAnswer != null) {
                    listOf(randomAnswer)
                } else {
                    emptyList()
                }
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
                _answers.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearAnswers() {
        _answers.value = emptyList()
        _error.value = null
    }

    // 添加一个调试方法
    fun debugDatabase() {
        viewModelScope.launch {
            val count = repository.getAnswerCount()
            Log.d("AnswerDebug", "Total answers in database: $count")

            val allAnswers = repository.getAllAnswersForDebug()
            Log.d("AnswerDebug", "All answers: ${allAnswers.joinToString("\n")}")

            // 测试特定组合的查询
            val zodiacGroup = "Water"  // 替换为实际使用的值
            val mbtiGroup = "INTJ"     // 替换为实际使用的值
            val answers = repository.getAllAnswersByGroups(zodiacGroup, mbtiGroup)
            Log.d("AnswerDebug", "Answers for $zodiacGroup-$mbtiGroup: ${answers.joinToString("\n")}")
        }
    }

    fun setSelectedZodiac(zodiac: String) {
        _selectedZodiac.value = zodiac
    }

    fun setSelectedMBTI(mbti: String) {
        _selectedMBTI.value = mbti
    }

    fun incrementRandomButtonClickCount() {
        _randomButtonClickCount.value = (_randomButtonClickCount.value ?: 0) + 1
    }

}
