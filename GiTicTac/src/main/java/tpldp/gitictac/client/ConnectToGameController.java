package tpldp.gitictac.client;

import tpldp.gitictac.utils.SceneController;
import tpldp.gitictac.utils.client.ClientUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tpldp.gitictac.utils.client.GameUtils;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectToGameController
{
    @FXML
    private TextField portText;
    @FXML
    private TextField ipText;

    @FXML
    public void connect(ActionEvent actionEvent) throws IOException {
        ClientUtils.client = new Client(ipText.getText(), Integer.parseInt(portText.getText()));
        ClientUtils.startClientListener();
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (GameUtils.boardSize == 5) {
            SceneController.showTabuleiro5();
        } else {
            SceneController.showTabuleiro10();
        }
    }
}