import java.io.*;
import java.net.*;
import javax.swing.JLabel;

/**
 * The TryConnectionHost class represents a host that listens for incoming connections from clients on a specified port.
 * It receives messages from clients and updates the connection status image on a JLabel component accordingly.
 * 
 * @author anes_
 */
public class TryConnectionHost extends Thread {

    /**
     * The JLabel component to display the connection status image
     */
    private JLabel imgStatus;
    
    /**
     * The port number to listen for incoming connections
     */
    private int port = 6000;

    /**
     * Constructs a TryConnectionHost object with the specified JLabel component to display the connection status.
     *
     * @param imgStatus the JLabel component to display the connection status image
     */
    public TryConnectionHost(JLabel imgStatus) {
        this.imgStatus = imgStatus;
    }

    /**
     * Starts the host thread. The host listens for incoming connections from clients,
     * receives messages from clients, and updates the connection status image accordingly.
     */
    @Override
    public void run() {
        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(6000);

                try (Socket socket = serverSocket.accept();
                     InputStream inputStream = socket.getInputStream();
                     ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

                    String message = (String) objectInputStream.readObject();

                    if (message.equals("sonoVivo")) {
                        imgStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pair.png")));
                    } else {
                        imgStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nopair.png")));
                    }
                } catch (IOException | ClassNotFoundException e) {
                    imgStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nopair.png")));
                }
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
