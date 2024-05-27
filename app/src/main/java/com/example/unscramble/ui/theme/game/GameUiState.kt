package com.example.aula2.ui.theme.game

data class GameUiState(
    val score: Int = 0,
    val currentWordCount: Int = 1,
    val currentScrambleWord: String = "",
    val currentRightWord: String = "",
    val inputValue: String = "",
    val isGuessedWordWrong: Boolean = false
)