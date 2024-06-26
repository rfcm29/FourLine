package tpldp.gitictac;

import tpldp.gitictac.utils.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MenuController {
    @FXML
    public void onCreateServer(ActionEvent actionEvent) throws IOException {
        SceneController.showLobby();
    }

    @FXML
    public void onConnectToGame(ActionEvent actionEvent) throws IOException {
        SceneController.showConnectLobby();
    }
}