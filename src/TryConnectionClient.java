import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * The TryConnectionClient class represents a client that continuously tries to establish a connection
 * with a server at a specified IP address and port. It sends a "sonoVivo" message to the server at regular intervals.
 * The status of the connection is indicated by an image on a JLabel component.
 * 
 * @author anes_
 */
public class TryConnectionClient extends Thread {

    private JLabel imgStatus;                 // The JLabel component to display the connection status image
    private String ip;                        // The IP address of the server
    private int port = 6000;                  // The port number of the server
    private int consecutiveFailedPackets;      // The number of consecutive failed packets sent to the server

    /**
     * Constructs a TryConnectionClient object with the specified JLabel component to display the connection status.
     *
     * @param imgStatus the JLabel component to display the connection status image
     */
    public TryConnectionClient(JLabel imgStatus) {
        this.imgStatus = imgStatus;
        this.consecutiveFailedPackets = 0;
    }

    /**
     * Starts the client thread. The client continuously tries to establish a connection with the server,
     * sends a "sonoVivo" message, and updates the connection status image accordingly.
     */
    @Override
    public void run() {
        String message = "sonoVivo";

        try {
            while (true) {
                ip = new String(Files.readAllBytes(Paths.get("connectionParam.txt")));
                Thread.sleep(1500);
                Socket socket = new Socket(ip, port);

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                objectOutputStream.writeObject(message);
                socket.close();
            }
        } catch (IOException e) {
        } catch (InterruptedException ex) {
            Logger.getLogger(TryConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
