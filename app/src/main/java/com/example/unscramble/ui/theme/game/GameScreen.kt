package com.example.unscramble.ui.theme.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.ui.theme.CustomTheme

@Composable
fun GameScreen() {
    val gameViewModel: GameViewModel = viewModel()
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Unscramble",
            style = CustomTheme.typography.body,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${gameUiState.currentWordCount}/${gameUiState.stepsLimit}",
            style = CustomTheme.typography.body,
        )

        Text(
            text = "Word: ${gameUiState.currentScrambleWord}",
            style = CustomTheme.typography.body,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "Unscramble the word using all the letters.",
            style = CustomTheme.typography.body,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "Correct word: ${gameUiState.currentRightWord}",
            style = CustomTheme.typography.body,
            fontWeight = FontWeight.Bold,
            color = CustomTheme.color.primary
        )

        TextField(
            value = gameUiState.inputValue,
            onValueChange = { gameViewModel.updateInputValue(it) },
            label = { Text("Enter text") },
            maxLines = 1,
            isError = gameUiState.isGuessedWordWrong,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                //background = CustomTheme.color.primary
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { gameViewModel.submit() },
                colors = ButtonDefaults.buttonColors(CustomTheme.color.primary)
            ) {
                Text(text = "Submit")
            }

            OutlinedButton(onClick = { gameViewModel.skip() }) {
                Text(text = "Skip")
            }
        }

        Text(
            text = "Score: ${gameUiState.score}",
            style = CustomTheme.typography.body,
        )

        if (gameUiState.isGameFinished) {
            Text(
                text = "Congratulations, you made it!",
                style = CustomTheme.typography.body,
                color = CustomTheme.color.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Button(
                onClick = { gameViewModel.startGame() },
                colors = ButtonDefaults.buttonColors(CustomTheme.color.primary)
            ) {
                Text(text = "Start again")
            }
        }
    }

}


@Preview
@Composable
private fun GameScreenPreview() {
    CustomTheme {
        GameScreen()
    }
}