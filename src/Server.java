import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class represents a server that listens for incoming connections and receives the instance of the game logic from clients.
 * It extends the Thread class to allow concurrent execution.
 * 
 * @author anes_
 */
public class Server extends Thread implements Serializable {

    /**
     * The GUI of the game
     */
    private GameUI gameUI;
    
    /**
     * The logic of teh game
     */
    public Logic logic;

    /**
     * Creates a new instance of the Server class.
     *
     * @param gameUI The GameUI instance associated with the server.
     */
    public Server(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    /**
     * The run method of the server thread.
     * It listens for incoming connections and receives the instance of the game logic from clients.
     */
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                logic = (Logic) objectInputStream.readObject();
                System.out.println("Received game logic");
                gameUI.logic = logic;
                gameUI.receiveBoard();

                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
