package tpldp.gitictac.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Player implements Runnable, Serializable {
    private Socket socket;
    private final transient ObjectInputStream input;
    private final transient ObjectOutputStream output;


    public Player(Socket socket) {
        this.socket = socket;
        try {
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Object object;

        while(true){
            try{
                object = input.readObject();
                System.out.println("teste");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}