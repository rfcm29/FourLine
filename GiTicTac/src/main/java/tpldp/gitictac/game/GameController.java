package tpldp.gitictac.game;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import tpldp.gitictac.client.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    //Tabuleiro
    @FXML private GridPane gridPane;
    private Button[][] buttons = new Button[5][5];

    //Jogador
    private String currentPlayer = "X";
    private Client client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Inicializa o array de botões
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonId = "#btn" + i + j;
                buttons[i][j] = (Button) gridPane.lookup(buttonId);
            }
        }

        try {
            client = new Client("localhost", 12345);
            startClientListener();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void startClientListener() {
        new Thread(() -> {
            try {
                while (true) {
                    int[] move = client.receiveMove();
                    int row = move[0];
                    int col = move[1];
                    Platform.runLater(() -> {
                        buttons[row][col].setText(currentPlayer);
                        togglePlayer();
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void handleButtonClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(currentPlayer);
            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);
            if (checkWin(row, col)) {
                // Handle win
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                togglePlayer();
                try {
                    client.sendMove(row, col);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    private boolean checkWin(int row, int col) {
        String currentPlayerSymbol = currentPlayer;

        //Verificação na horizontal (esquerda e direita)
        if (countConsecutive(row, col, 0, 1) + countConsecutive(row, col, 0, -1) >= 4) {
            return true;
        }

        //Verificação na vertical (cima e baixo)
        if (countConsecutive(row, col, 1, 0) + countConsecutive(row, col, -1, 0) >= 4) {
            return true;
        }

        //Verificação na diagonal (superior esquerdo para inferior direito)
        if (countConsecutive(row, col, 1, 1) + countConsecutive(row, col, -1, -1) >= 4) {
            return true;
        }

        //Verificação na diagonal (superior direito para inferior esquerdo)
        if (countConsecutive(row, col, 1, -1) + countConsecutive(row, col, -1, 1) >= 4) {
            return true;
        }

        return false;
    }

    private int countConsecutive(int row, int col, int rowIncrement, int colIncrement) {
        int count = 0;
        String symbol = currentPlayer;
        int newRow = row + rowIncrement;
        int newCol = col + colIncrement;

        while (isValidPosition(newRow, newCol) && buttons[newRow][newCol].getText().equals(symbol)) {
            count++;
            newRow += rowIncrement;
            newCol += colIncrement;
        }

        return count;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }
}
