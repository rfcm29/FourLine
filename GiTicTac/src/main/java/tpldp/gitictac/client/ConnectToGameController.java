package tpldp.gitictac.client;

import tpldp.gitictac.utils.SceneController;
import tpldp.gitictac.utils.client.ClientUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ConnectToGameController
{
    @FXML
    private TextField portText;
    @FXML
    private TextField ipText;

    @FXML
    public void initialize() {

    }

    @FXML
    public void connect(ActionEvent actionEvent) throws IOException {
        ClientUtils.client = new Client(ipText.getText(), Integer.parseInt(portText.getText()));
        SceneController.showGame();
    }
}