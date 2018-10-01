
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Handles behaviors for the client side of the File Chooser. Many methods and variables were taken from
 * Java How To Program (Early Objects) (10th Edition) example fig28_03_06.
 */
public class FileChooserClient extends JFrame {
    /**
     *  Enters information from user. Credit given to the book for the variable.
     */
    private JTextField enterField;
    /**
     * Display information to user. Credit given to the book for the variable.
     */
    private JTextArea displayArea;
    /**
     * Output stream to server. Credit given to the book for the variable.
     */
    private ObjectOutputStream output;
    /**
     * Input stream from server. Credit given to the book for the variable.
     */
    private ObjectInputStream input;
    /**
     * Message from server. Credit given to the book for the variable.
     */
    private String message = "";
    /**
     * Host server for this application. Credit given to the book for the variable.
     */
    private String chatServer;    /**
     * Socket to communicate with server. Credit given to the book for the variable.
     */
    private Socket client;

    /**
     * Constructor for the FileChooserClient. Initializes chatServer and set up GUI.
     * @param host IP of the server to connect to.
     */
    public FileChooserClient(String host) {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        sendData(event.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * Connect to server and process messages from server.
     */
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * Connect to server.
     * @throws IOException Error connecting to the server.
     */
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }

    /**
     * Get streams to send and receive data.
     * @throws IOException Error getting the streams.
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * Process connection with server.
     * @throws IOException Error processing the connection.
     */
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("TERMINATE"));
    }

    /**
     * Close streams and socket.
     */
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try {
            if(output != null)
            {
                output.close(); // close output stream
            }

            if(input != null)
            {
                input.close(); // close input stream
            }

            if(client != null)
            {
                client.close(); // close socket
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Send message to server.
     * @param message Desired message to send.
     */
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * Manipulates displayArea in the event-dispatch thread.
     * @param messageToDisplay Desired message to display.
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * Manipulates enterField in the event-dispatch thread.
     * @param editable Whether or not to have the text field editable.
     */
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}