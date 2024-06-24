package com.example.fourline.server;

import java.net.Socket;

public class Player implements Runnable{
    private Socket socket;

    public Player(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
