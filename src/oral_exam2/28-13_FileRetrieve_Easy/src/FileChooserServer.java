import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 * Handles behaviors for the server side of the File Chooser. Many methods and variables were taken from
 * Java How To Program (Early Objects) (10th Edition) example fig28_03_06.
 */
public class FileChooserServer extends JFrame {
    /**
     * Inputs message from user. Credit given to the book for the variable.
     */
    private JTextField enterField;
    /**
     * Display information to user. Credit given to the book for the variable.
     */
    private JTextArea displayArea;
    /**
     * Output stream to client. Credit given to the book for the variable.
     */
    private ObjectOutputStream output;
    /**
     * Input stream from client. Credit given to the book for the variable.
     */
    private ObjectInputStream input;
    /**
     * Server socket. Credit given to the book for the variable.
     */
    private ServerSocket server;
    /**
     * Connection to client. Credit given to the book for the variable.
     */
    private Socket connection;
    /**
     * Counter of number of connections. Credit given to the book for the variable.
     */
    private int counter = 1;

    /**
     * Constructor for the FileChooserServer. Creates the GUI and adds an action listener.
     */
    public FileChooserServer() {
        super("Server");

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to client
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
     * Set up and run server. Credit given to the book for the code.
     */
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Wait for connection to arrive, then display connection info. Credit given to the book for the code.
     * @throws IOException Failed connection
     */
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
    }

    /**
     * Get streams to send and receive data. Credit given to the book for the code.
     * @throws IOException Failed to set up streams
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * Process connection with client. This is where the server reads in the file and displays the contents. Credit given to the book for some of the code.
     * @throws IOException Failed to transmit the data correctly
     */
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // Send connection successful message

        //Enable enterField so server user can send messages
        setTextFieldEditable(true);

        do // Process messages sent from client
        {
            try // Read message and display it
            {
                message = (String) input.readObject(); // Read new message
                displayMessage("\nRequested file: " + message); // Display message
                //Check if file exists. If true, send contents of file, otherwise send "file does not exist" message back to the client

                File requestedFile = new File(message); //Tries to find a file from the message sent.
                sendData(fileToString(requestedFile)); //Sends the contents of the text file.

            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            } catch(FileNotFoundException fileNotFoundException){
                displayMessage("\nFile not found");
                sendData("The file " + message + " does not exist");
            }

        } while(!message.equals("TERMINATE"));
    }

    /**
     * Close streams and socket. Credit given to the book for the code.
     */
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Send message to client. Credit given to the book for the code.
     * @param message Desired message to send to the client.
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * Manipulates displayArea in the event-dispatch thread. Credit given to the book for the code.
     * @param messageToDisplay Desired message to display.
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // append message
                    }
                }
        );
    }

    /**
     * Manipulates enterField in the event-dispatch thread. Credit given to the book for the method.
     * @param editable Whether or not the text field can be edited.
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

    /**
     * Converts a file to a String.
     * @param fileName Name of the file. Should be the path to the file.
     * @return String representing the contents of the text file.
     * @throws IOException Error with the buffered reader reading the file.
     */
    private String fileToString(File fileName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } finally {
            bufferedReader.close();
        }
    }
}