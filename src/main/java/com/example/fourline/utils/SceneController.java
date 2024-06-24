package com.example.fourline.utils;

import com.example.fourline.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class SceneController {
    public static Stage stage;

    public static void menu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("MENU!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showLobby() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("server/server-lobby.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("LOBBY!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showConnectLobby() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client/connect-to-game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("CONNECT TO SERVER!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client/game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("GAME!");
        stage.setScene(scene);
        stage.show();
    }
}
