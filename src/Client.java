import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The Client class represents a client that sends a Logic instance
 * of a checkers game to a server using a Socket connection.
 * 
 * @author anes_
 */
public class Client implements Serializable {

    
    /** The IP address of the server to connect to. */
    String ip;

    /** The port number to connect to. */
    int port = 5000;

    /**
     * Default constructor
     */
    public Client() {}
    
    /**
     * Sends the provided Logic instance to the server.
     *
     * @param logic The Logic instance representing the game to send.
     */
    public void send(Logic logic) {
        try {
            // Read the IP address from a file
            ip = new String(Files.readAllBytes(Paths.get("connectionParam.txt")));

            // Create a socket connection to the server
            Socket socket = new Socket(ip, port);

            // Get the output stream from the socket
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // Print the IP address to the console
            System.out.println("ip = " + ip);

            // Write the Logic instance to the output stream
            objectOutputStream.writeObject(logic);

            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
