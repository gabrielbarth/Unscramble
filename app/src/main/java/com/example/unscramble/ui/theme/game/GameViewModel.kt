package com.example.unscramble.ui.theme.game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        getRandomWord()
    }

    fun updateInputValue(inputValue: String) {
        _uiState.update {
            it.copy(inputValue = inputValue)
        }
    }

    fun submit() {
        val currentState = _uiState.value
        if (currentState.currentRightWord.equals(currentState.inputValue)) {
            updateScore()
            skip()
        } else {
            updateErrorState(true)
        }
    }

    private fun updateErrorState(isWrong: Boolean) {
        _uiState.update {
            it.copy(isGuessedWordWrong = isWrong)
        }
    }

    private fun clearField() {
        _uiState.update {
            it.copy(inputValue = "")
        }
    }

    fun updateScore() {
        _uiState.update {
            it.copy(score = it.score.inc())
        }
    }

    fun skip() {
        clearField()
        updateErrorState(false)
        _uiState.update {
            it.copy(
                currentWordCount = it.currentWordCount.inc()
            )
        }
        getRandomWord()
    }

    // dont use same word
    private fun getRandomWord() {
        val currentRightWord = allWords.random()
        val listWords = currentRightWord.toCharArray()
        listWords.shuffle()
        val currentScrambleWord = String(listWords)
        _uiState.update {
            it.copy(currentRightWord = currentRightWord, currentScrambleWord = currentScrambleWord)
        }

    }
}