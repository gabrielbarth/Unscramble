package com.example.unscramble.ui.theme.game

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.ui.theme.UnscrambleTheme

@Composable
fun GameScreen() {
    val gameViewModel: GameViewModel = viewModel()
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column {

        Text(text = "Unscramble")

        Text(text = "${gameUiState.currentWordCount}/${gameUiState.stepsLimit}")


        Text(text = "Word: ${gameUiState.currentScrambleWord}")
        Text(text = "Unscramble the word using all the letters.")


        Text(text = "correct word: ${gameUiState.currentRightWord}")

        TextField(
            value = gameUiState.inputValue,
            onValueChange = { gameViewModel.updateInputValue(it) },
            label = { Text("Enter text") },
            maxLines = 1,
            isError = gameUiState.isGuessedWordWrong,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            ),
        )

        Button(onClick = { gameViewModel.submit() }) {
            Text(text = "Submit")
        }

        OutlinedButton(onClick = { gameViewModel.skip() }) {
            Text(text = "Skip")
        }

        Text(text = "Score: ${gameUiState.score}")

        if(gameUiState.isGameFinished) {
            Text(text = "Congratulations, you made it!")
            Button(onClick = { gameViewModel.startGame() }) {
                Text(text = "Start again")
            }
        }

    }
}


@Preview
@Composable
private fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}