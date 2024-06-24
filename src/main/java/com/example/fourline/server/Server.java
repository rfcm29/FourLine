package com.example.fourline.server;

import com.example.fourline.utils.server.ServerUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class Server {
    private Integer port;
    private String ip;

    private ServerSocket serverSocket;
    private List<Player> players;

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    public Server() {
        this.port = randomPort();
        this.ip = getIp();
        this.players = new ArrayList<>();

        ServerUtils.setInfo(this.ip, this.port);

        executorService.submit(this::startServer);
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(this.port);
            while(true){
                System.out.println("Server Accept Connections");
                Socket socket = serverSocket.accept();
                Player player = new Player(socket);
                this.players.add(player);

                Thread thread = new Thread(player);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private int randomPort() {
        return ThreadLocalRandom.current().nextInt(1000, 9999);
    }
}
