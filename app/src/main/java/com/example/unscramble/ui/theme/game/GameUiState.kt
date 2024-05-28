package com.example.unscramble.ui.theme.game

data class GameUiState(
    val score: Int = 0,
    val currentWordCount: Int = 1,
    val currentScrambleWord: String = "",
    val currentRightWord: String = "",
    var inputValue: String = "",
    val isGuessedWordWrong: Boolean = false,
    val isGameFinished: Boolean = false,
    val stepsLimit: Int = 10
)