package Chat.Client;

import Chat.Models.Answer;
import Chat.Models.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public class ClientGUI extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private final JLabel label;
    private final JTextField tf;
    private final JButton login;
    private final JButton logout;
    private final JTextArea ta;
    private final int defaultPort;
    private final String defaultHost;

    private boolean connected;
    private Client client;

    ClientGUI(String host, int port) {
        super("Chat Client");
        defaultPort = port;
        defaultHost = host;
        JPanel northPanel = new JPanel(new GridLayout(3, 1));
        label = new JLabel("Enter your username below", SwingConstants.CENTER);
        northPanel.add(label);
        tf = new JTextField("Anonymous");
        tf.setBackground(Color.WHITE);
        northPanel.add(tf);
        add(northPanel, BorderLayout.NORTH);
        ta = new JTextArea("Welcome to the Chat room\n", 80, 80);
        JPanel centerPanel = new JPanel(new GridLayout(1, 1));
        centerPanel.add(new JScrollPane(ta));
        ta.setEditable(false);
        add(centerPanel, BorderLayout.CENTER);
        login = new JButton("Login");
        login.addActionListener(this);
        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setEnabled(false);
        JPanel southPanel = new JPanel();
        southPanel.add(login);
        southPanel.add(logout);
        add(southPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        tf.requestFocus();
    }

    void append(String str) {
        ta.append(str);
        ta.setCaretPosition(ta.getText().length() - 1);
    }

    void connectionFailed() {
        login.setEnabled(true);
        logout.setEnabled(false);
        label.setText("Enter your username below");
        tf.setText("Anonymous");
        tf.removeActionListener(this);
        connected = false;
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == logout) {
            client.sendMessage(new Answer(MessageType.Logout, ""));
            return;
        }

        if (connected) {
            client.sendMessage(new Answer(MessageType.Answer, tf.getText()));
            tf.setText("");
            return;
        }
        if (o == login) {
            String username = tf.getText().trim();
            if (username.length() == 0)
                return;

            client = new Client(defaultHost, defaultPort, username, this);

            if (!client.start())
                return;
            tf.setText("");
            label.setText("Enter your message below");
            connected = true;

            login.setEnabled(false);

            logout.setEnabled(true);

            tf.addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new ClientGUI("localhost", 1500);
    }
}