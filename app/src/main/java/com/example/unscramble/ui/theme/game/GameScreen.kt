package com.example.aula2.ui.theme.game

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aula2.ui.theme.CustomTheme

@Composable
fun GameScreen() {
    val gameViewModel: GameViewModel = viewModel()
    val gameUiState by gameViewModel.uiState.collectAsState()


    Column {
        Button(onClick = { gameViewModel.submit() }) {
            Text(text = "")
        }

        OutlinedButton(onClick = { gameViewModel.updateScore() }) {

        }

        Text(text = "Score ${gameUiState.score}")

    }
}

@Preview
@Composable
private fun GameScreenPreview() {
    CustomTheme {
        GameScreen()
    }
}