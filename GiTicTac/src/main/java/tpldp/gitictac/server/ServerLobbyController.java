package tpldp.gitictac.server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import tpldp.gitictac.utils.SceneController;
import tpldp.gitictac.utils.server.ServerUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerLobbyController implements Initializable
{
    private Server server;
    @FXML
    private Label ipLabel;
    @FXML
    private Label portLabel;
    @FXML
    private ComboBox<String> tabuleiro;
    @FXML
    private Button escolherBtn;

    public ServerLobbyController(){
        ServerUtils.controller = this;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> options = FXCollections.observableArrayList("5x5", "10x10");
        tabuleiro.setItems(options);
    }

    @Deprecated
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneController.menu();
    }

    public void setInfo(String ip, Integer port){
        this.ipLabel.setText(ip);
        this.portLabel.setText(String.valueOf(port));
    }

    @FXML
    public void setTabuleiro(ActionEvent actionEvent) {
        tabuleiro.setDisable(true);
        escolherBtn.setDisable(true);
        int boardSize = tabuleiro.getValue().equals("5x5") ? 5 : 10;

        this.server = new Server(boardSize);
    }
}