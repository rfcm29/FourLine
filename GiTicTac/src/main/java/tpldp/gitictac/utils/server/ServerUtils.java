package tpldp.gitictac.utils.server;

import tpldp.gitictac.server.ServerLobbyController;

public final class ServerUtils {
    public static ServerLobbyController controller;

    public static void setInfo(String ip, Integer port){
        controller.setInfo(ip, port);
    }
}