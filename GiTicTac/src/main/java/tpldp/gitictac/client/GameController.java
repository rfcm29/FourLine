package tpldp.gitictac.client;

import tpldp.gitictac.utils.client.GameUtils;
import javafx.fxml.FXML;

public class GameController
{
    public GameController(){
        GameUtils.controller = this;
    }

    @FXML
    public void initialize() {
    }}