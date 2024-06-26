package tpldp.gitictac.utils;

import tpldp.gitictac.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class SceneController {
    public static Stage stage;

    public static void menu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 418);
        stage.setTitle("MENU!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showLobby() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("server/server-lobby.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 418);
        stage.setTitle("LOBBY!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showConnectLobby() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client/connect-to-game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 418);
        stage.setTitle("CONNECT TO SERVER!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showTabuleiro5() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client/tabuleiro-5.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 418);
        stage.setTitle("JOGO!");
        stage.setScene(scene);
        stage.show();
    }

    public static void showTabuleiro10() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("client/tabuleiro-10.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 594, 418);
        stage.setTitle("JOGO!");
        stage.setScene(scene);
        stage.show();
    }
}