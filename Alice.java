import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Alice extends Frame implements ActionListener, Runnable {

    // UI Components
    TextField inputField;
    TextArea chatArea;
    Button sendButton;

    // Network Components
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    Thread chatThread;

    // Constructor
    public Alice() {

        // Create UI
        inputField = new TextField();
        chatArea = new TextArea();
        sendButton = new Button("Send");

        sendButton.addActionListener(this);

        // Layout
        setLayout(new BorderLayout());

        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(chatArea, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Window Close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    if (socket != null)
                        socket.close();

                    if (serverSocket != null)
                        serverSocket.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                System.exit(0);
            }
        });

        // Server Connection
        try {
            serverSocket = new ServerSocket(12000);

            chatArea.append("Waiting for Bob...\n");

            socket = serverSocket.accept();

            chatArea.append("Bob Connected!\n");

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Start Receiver Thread
        chatThread = new Thread(this);
        chatThread.start();

        // Frame Settings
        setTitle("Alice (Server)");
        setSize(400, 400);
        setVisible(true);
    }

    // Send Message
    public void actionPerformed(ActionEvent e) {

        String msg = inputField.getText().trim();

        if (msg.isEmpty())
            return;

        chatArea.append("Alice: " + msg + "\n");

        inputField.setText("");

        try {
            dos.writeUTF(msg);
            dos.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Receive Messages
    public void run() {

        while (true) {

            try {
                String msg = dis.readUTF();

                chatArea.append("Bob: " + msg + "\n");

            } catch (Exception e) {
                chatArea.append("Connection Closed\n");
                break;
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        new Alice();
    }
}
