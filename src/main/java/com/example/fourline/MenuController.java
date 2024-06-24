package com.example.fourline;

import com.example.fourline.utils.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onCreateServer(ActionEvent actionEvent) throws IOException {
        SceneController.showLobby();
    }

    @FXML
    public void onConnectToGame(ActionEvent actionEvent) throws IOException {
        SceneController.showConnectLobby();
    }
}