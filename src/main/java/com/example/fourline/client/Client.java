package com.example.fourline.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public Client(String ip, String port) throws IOException {
        Socket socket = new Socket(ip, Integer.parseInt(port));
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }
}
