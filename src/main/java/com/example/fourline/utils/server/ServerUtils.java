package com.example.fourline.utils.server;

import com.example.fourline.server.ServerLobbyController;

public final class ServerUtils {
    public static ServerLobbyController controller;

    public static void setInfo(String ip, Integer port){
        controller.setInfo(ip, port);
    }

    public static void addLine(String text){
        controller.addLine(text);
    }
}
