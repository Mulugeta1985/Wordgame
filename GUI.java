import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

        private List<String> players = new ArrayList<>();
        private String host;
        public static String gameText = "";
        public static boolean isCheckBoxSelected = false;
        public boolean onceGamePlay = false;

        public GUI() {
                JPanel contentPane = new JPanel();
                setContentPane(contentPane);
                setTitle("Simple Game Application");
                setSize(400, 300);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Set Jframe in Center.......................................
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
                // ..........................................................
                JLabel playersLabel = new JLabel("Current Players: " + String.join(", ", players));
                playersLabel.setForeground(Color.white);
                // add(playersLabel);
                JButton addPlayerButton = new JButton("Add Player");
                addPlayerButton.addActionListener(e -> {
                        String playerName = JOptionPane.showInputDialog("Enter player name:");
                        players.add(playerName);
                        playersLabel.setText("Current Players: " + String.join(", ", players));
                });
                // add(addPlayerButton);
                JLabel hostLabel = new JLabel("Host: ");
                hostLabel.setForeground(Color.white);
                // add(hostLabel);
                JButton addHostButton = new JButton("Add Host");

                // add(addHostButton);
                JLabel playingPhraseLabel = new JLabel("Playing Phrase: _______________");
                playingPhraseLabel.setForeground(Color.white);
                // add(playingPhraseLabel);
                JButton startTurnButton = new JButton("Start Turns");
                startTurnButton.addActionListener(e -> {
                        if (onceGamePlay == true) {
                                String gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                                Phrases phrases = new Phrases(gamePhrase);
                                playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
                        }

                        onceGamePlay = true;
                        while (true) {
                                boolean correctGuess = false;
                                String guess = JOptionPane.showInputDialog("Enter a letter to guess: ");

                                try {
                                        correctGuess = Phrases.findLetters(guess);
                                } catch (MultipleLettersException ex) {
                                        System.out.println(ex.getMessage());
                                }
                                if (correctGuess) {
                                        String playChoice = JOptionPane.showInputDialog("Continue playing? (Y/N): ");
                                        try {
                                                if (!playChoice.equalsIgnoreCase("Y")) {
                                                        System.exit(0);
                                                } else {

                                                        String gamePhrase = JOptionPane
                                                                        .showInputDialog("Enter game phrase:");
                                                        Phrases phrases = new Phrases(gamePhrase);
                                                        playingPhraseLabel.setText("Playing Phrase: "
                                                                        + phrases.getPlayingPhrase());
                                                }
                                        } catch (Exception ex) {
                                                System.out.println("No Input Enter");
                                                return;
                                        }
                                        // System.out.print("Continue playing? (Y/N): ");
                                        // String playChoice = scanner.nextLine();
                                        // if (!playChoice.equalsIgnoreCase("Y")) {
                                        // continueGame = false;
                                        // }else{
                                        // host.createPharase();
                                        // }
                                }

                        }

                });

                JCheckBox checkBox1 = new JCheckBox("Save Messages");
                checkBox1.setBounds(100, 100, 50, 50);
                checkBox1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (checkBox1.isSelected()) {
                                        isCheckBoxSelected = true;
                                } else {
                                        isCheckBoxSelected = false;
                                }
                        }
                });

                String description = "Save Message When Checked";
                checkBox1.setToolTipText(description);
                // add(startTurnButton);
                JPanel panel = new JPanel(new GridLayout(5, 1)); // 2 rows, 3 columns
                panel.setBackground(Color.gray);
                panel.add(checkBox1);
                panel.add(playersLabel);
                panel.add(hostLabel);
                panel.add(startTurnButton);
                panel.add(playingPhraseLabel);

                add(panel);

                addHostButton.addActionListener(e -> {
                        String hostName = JOptionPane.showInputDialog("Enter host name:");
                        String gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                        Phrases phrases = new Phrases(gamePhrase);
                        playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
                        host = hostName;
                        hostLabel.setText("Host: " + host);
                });

                setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

                // Create the menu bar
                JMenuBar menuBar = new JMenuBar();

                // Create menus
                JMenu gameMenu = new JMenu("Game");
                JMenu aboutMenu = new JMenu("About");
                // Create menu items
                JMenuItem addPlayer = new JMenuItem("Add Player");
                JMenuItem addHost = new JMenuItem("Add Host ");

                JMenuItem layoutMenu = new JMenuItem("Layout");
                // Add menu items to the menu
                gameMenu.add(addPlayer);
                gameMenu.add(addHost);
                gameMenu.addSeparator(); // Adds a separator between Load and Exit

                aboutMenu.add(layoutMenu);

                // Add action listeners to menu items
                menuBar.add(gameMenu);
                menuBar.add(aboutMenu);
                // Set the menu bar to the frame
                setJMenuBar(menuBar);

                addPlayer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String playerName = JOptionPane.showInputDialog("Enter player name:");
                                players.add(playerName);
                                playersLabel.setText("Current Players: " + String.join(", ", players));
                        }
                });

                addHost.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String hostName = JOptionPane.showInputDialog("Enter host name:");
                                String gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                                Phrases phrases = new Phrases(gamePhrase);
                                playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
                                host = hostName;
                                hostLabel.setText("Host: " + host);
                        }
                });
                layoutMenu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                new TextAreaForSavingMessage();
                        }
                });

                // Add key bindings for Alt-G
                InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.ALT_DOWN_MASK), "altG");
                ActionMap actionMap = contentPane.getActionMap();
                actionMap.put("altG", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Action to perform when Alt-G is pressed
                                gameMenu.doClick();
                        }
                });

                // Add key bindings for Alt-G
                InputMap inputMaping = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
                inputMaping.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_DOWN_MASK), "altA");
                ActionMap actionMapp = contentPane.getActionMap();
                actionMapp.put("altA", new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Action to perform when Alt-G is pressed
                                aboutMenu.doClick();
                        }
                });

                setVisible(true);
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(GUI::new);
        }
}
