package Chat.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;


public class ServerGUI extends JFrame implements ActionListener, WindowListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private final JButton serverSwitcher;
    private final JTextArea chatTextArea;
    private final JTextArea eventTextArea;
    private Server server;

    ServerGUI() {
        super("Chat Server");
        server = null;

        JPanel north = new JPanel();
        serverSwitcher = new JButton("Start");
        serverSwitcher.addActionListener(this);
        north.add(serverSwitcher);
        add(north, BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(2, 1));
        chatTextArea = new JTextArea(80, 80);
        chatTextArea.setEditable(false);
        appendRoom("Chat room.\n");
        center.add(new JScrollPane(chatTextArea));
        eventTextArea = new JTextArea(80, 80);
        eventTextArea.setEditable(false);
        appendEvent("Events log.\n");
        center.add(new JScrollPane(eventTextArea));
        add(center);
        addWindowListener(this);
        setSize(400, 600);
        setVisible(true);
    }

    void appendRoom(String str) {
        chatTextArea.append(str);
        chatTextArea.setCaretPosition(chatTextArea.getText().length() - 1);
    }

    void appendEvent(String str) {
        eventTextArea.append(str);
        eventTextArea.setCaretPosition(chatTextArea.getText().length() - 1);
    }

    public void actionPerformed(ActionEvent e) {
        if (server != null) {
            server.stop();
            server = null;
            serverSwitcher.setText("Start");
            return;
        }

        int defaultPort = 1500;
        server = new Server(defaultPort, this);

        new ServerRunning().start();
        serverSwitcher.setText("Stop");
    }

    public static void main(String[] arg) {
        new ServerGUI();
    }

    public void windowClosing(WindowEvent e) {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception ignored) {
            }
            server = null;
        }

        dispose();
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    class ServerRunning extends Thread {
        public void run() {
            server.start();
            serverSwitcher.setText("Start");
            appendEvent("Server crashed\n");
            server = null;
        }
    }
}
