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
        public static int phraseTotalCount = 0;
        public static int correctGuessCount = 0;
        public static JLabel playingPhraseLabel;
        public ArrayList<String> guessArray = new ArrayList<String>();
        String gamePhrase = "";
        // Create the JTextArea
        public static JTextArea textAreaForMessages = new JTextArea(10, 10); // 10 rows and 10 columns

        public GUI() {
                JPanel contentPane = new JPanel();
                setContentPane(contentPane);
                setTitle("Simple Game Application");

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
                playingPhraseLabel = new JLabel("Playing Phrase: _______________");
                playingPhraseLabel.setForeground(Color.white);
                // add(playingPhraseLabel);
                JButton startTurnButton = new JButton("Start Turns");
                startTurnButton.addActionListener(e -> {
                        if (onceGamePlay == true) {
                                gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                                phraseTotalCount = gamePhrase.replaceAll("\\s", "").length();
                                Phrases phrases = new Phrases(gamePhrase);
                                playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
                        }

                        onceGamePlay = true;
                        while (true) {
                                boolean correctGuess = false;
                                String guess = JOptionPane.showInputDialog("Enter a letter to guess: ");

                                try {
                                        correctGuess = Phrases.findLetters(guess);
                                        if (correctGuess) {
                                                setPhrase(gamePhrase, guess);
                                                correctGuessCount = correctGuessCount
                                                                + findNumberOfPresenceOfCharInString(gamePhrase,
                                                                                guess.charAt(0));

                                                if (correctGuessCount == phraseTotalCount) {
                                                        if (isCheckBoxSelected) {
                                                                textAreaForMessages.append(
                                                                                "Congratulations! You've guessed Correctly All The character in word successully\n");
                                                        } else {
                                                                textAreaForMessages.setText(
                                                                                "Congratulations! You've guessed Correctly All The character in word successully\n");
                                                        }

                                                } else if (correctGuessCount < phraseTotalCount) {
                                                        correctGuess = false;
                                                        if (isCheckBoxSelected) {
                                                                textAreaForMessages.append(
                                                                                "Congratulations! You've guessed Correct\n");
                                                        } else {
                                                                textAreaForMessages.setText(
                                                                                "Congratulations! You've guessed Correct\n");
                                                        }
                                                        // JOptionPane.showMessageDialog(null, "Congratulations! You've
                                                        // guessed correct Char from the phrase please guessed next");
                                                }
                                        }

                                } catch (MultipleLettersException ex) {
                                        System.out.println(ex.getMessage());
                                }
                                if (correctGuess) {
                                        guessArray.clear();
                                        phraseTotalCount = 0;
                                        correctGuessCount = 0;
                                        String playChoice = JOptionPane.showInputDialog("Continue playing? (Y/N): ");
                                        try {
                                                if (!playChoice.equalsIgnoreCase("Y")) {
                                                        System.exit(0);
                                                } else {
                                                        textAreaForMessages.setText("");
                                                        gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                                                        phraseTotalCount = gamePhrase.replaceAll("\\s", "").length();
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

                textAreaForMessages.setLineWrap(true); // Enable line wrapping
                textAreaForMessages.setWrapStyleWord(true); // Wrap at word boundaries

                // Set preferred size to control width and height
                // textAreaForMessages.setPreferredSize(new java.awt.Dimension(300, 200)); //
                // Width, Height
                // Add JTextArea to a JScrollPane for scrolling
                JScrollPane scrollPane = new JScrollPane(textAreaForMessages);

                String description = "Save Message When Checked";
                checkBox1.setToolTipText(description);
                // add(startTurnButton);
                JPanel panel = new JPanel(new GridLayout(6, 1)); // 6 rows, 1 columns
                panel.setBackground(Color.gray);
                panel.add(checkBox1);

                panel.add(playersLabel);
                panel.add(hostLabel);
                panel.add(startTurnButton);
                panel.add(playingPhraseLabel);
                panel.add(scrollPane);

                add(panel);

                addHostButton.addActionListener(e -> {
                        String hostName = JOptionPane.showInputDialog("Enter host name:");
                        gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                        phraseTotalCount = gamePhrase.replaceAll("\\s", "").length();
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
                                gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                                phraseTotalCount = gamePhrase.replaceAll("\\s", "").length();
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
                setSize(400, 390);

                setVisible(true);
        }

        public void setPhrase(String phrase, String character) {
                guessArray.add(character);
                String gamePhrase = phrase; // Replace with your actual game phrase

                // Create a StringBuilder to build the modified string
                StringBuilder modifiedPhrase = new StringBuilder();

                // Loop through each character in the original string
                for (int i = 0; i < gamePhrase.length(); i++) {
                        char currentChar = gamePhrase.charAt(i);
                        String currentCharS = currentChar + "";

                        // Check if the character is the one to exclude
                        if (guessArray.contains(currentCharS)) {
                                modifiedPhrase.append(currentChar);
                        } else if (currentCharS.equals(" ")) {
                                modifiedPhrase.append(" ");
                        } else {
                                modifiedPhrase.append("_");

                        }
                }

                // Convert StringBuilder back to String
                String phrases = modifiedPhrase.toString();
                playingPhraseLabel.setText("Playing Phrase: " + phrases);
        }

        public int findNumberOfPresenceOfCharInString(String gamePhrase, char charToCount) {

                int count = 0;

                // Loop through each character in the string
                for (int i = 0; i < gamePhrase.length(); i++) {
                        if (gamePhrase.charAt(i) == charToCount) {
                                count++;
                        }
                }
                return count;
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(GUI::new);
        }
}
