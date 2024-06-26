package com.example.fourline.server;

import com.example.fourline.utils.SceneController;
import com.example.fourline.utils.server.ServerUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class ServerLobbyController
{
    private Server server;
    @FXML
    private Label ipLabel;
    @FXML
    private Label portLabel;
    @FXML
    private VBox gameHistory;

    public ServerLobbyController(){
        ServerUtils.controller = this;
    }

    @FXML
    public void initialize() {
        this.server = new Server();
    }

    @Deprecated
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneController.menu();
    }

    public void setInfo(String ip, Integer port){
        this.ipLabel.setText(ip);
        this.portLabel.setText(String.valueOf(port));
    }

    public void addLine(String text){
        Platform.runLater(() -> gameHistory.getChildren().add(new Text(text)));
    }
}