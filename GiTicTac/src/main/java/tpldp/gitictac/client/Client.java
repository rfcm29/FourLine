package tpldp.gitictac.client;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;

    public Client(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        //dataOutputStream.flush();
        dataInputStream = new DataInputStream(socket.getInputStream());
    }

    public void sendMove(int row, int col) throws IOException {
        dataOutputStream.writeInt(row);
        dataOutputStream.writeInt(col);
    }

    public int[] receiveMove() throws IOException {
        int row = dataInputStream.readInt();
        int col = dataInputStream.readInt();
        return new int[] { row, col };
    }
}