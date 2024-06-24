package tpldp.gitictac.server;

import tpldp.gitictac.utils.SceneController;
import tpldp.gitictac.utils.server.ServerUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class ServerLobbyController
{
    private Server server;
    @FXML
    private Label ipLabel;
    @FXML
    private Label portLabel;

    public ServerLobbyController(){
        ServerUtils.controller = this;
    }

    @FXML
    public void initialize() {
        this.server = new Server();
    }

    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneController.menu();
    }

    public void setInfo(String ip, Integer port){
        this.ipLabel.setText(ip);
        this.portLabel.setText(String.valueOf(port));
    }
}