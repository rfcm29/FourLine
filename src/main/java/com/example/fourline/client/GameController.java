package com.example.fourline.client;

import com.example.fourline.utils.client.GameUtils;
import javafx.fxml.FXML;

public class GameController
{
    public GameController(){
        GameUtils.controller = this;
    }

    @FXML
    public void initialize() {
    }}