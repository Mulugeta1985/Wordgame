import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    private List<String> players = new ArrayList<>();
    private String host;

    public GUI() {
        setTitle("Simple Game Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Jframe in Center.......................................
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        //..........................................................
        JLabel playersLabel = new JLabel("Current Players: " + String.join(", ", players));
        add(playersLabel);
        JButton addPlayerButton = new JButton("Add Player");
        addPlayerButton.addActionListener(e -> {
            String playerName = JOptionPane.showInputDialog("Enter player name:");
            players.add(playerName);
            playersLabel.setText("Current Players: " + String.join(", ", players));
        });
        add(addPlayerButton);
        JLabel hostLabel = new JLabel("Host: " + host);
        add(hostLabel);
        JButton addHostButton = new JButton("Add Host");

        add(addHostButton);
        JLabel playingPhraseLabel = new JLabel("Playing Phrase: _______________");
        add(playingPhraseLabel);
        JButton startTurnButton = new JButton("Start Turns");
        startTurnButton.addActionListener(e -> {
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
                    if (!playChoice.equalsIgnoreCase("Y")) {
                        System.exit(0);
                    } else {
                        String gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
                        Phrases phrases = new Phrases(gamePhrase);
                        playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
                    }
//                        System.out.print("Continue playing? (Y/N): ");
//                        String playChoice = scanner.nextLine();
//                        if (!playChoice.equalsIgnoreCase("Y")) {
//                                continueGame = false;
//                        }else{
//                              host.createPharase();
//                        }
                }

            }

        });
        add(startTurnButton);

        addHostButton.addActionListener(e -> {
            String hostName = JOptionPane.showInputDialog("Enter host name:");
            String gamePhrase = JOptionPane.showInputDialog("Enter game phrase:");
            Phrases phrases = new Phrases(gamePhrase);
            playingPhraseLabel.setText("Playing Phrase: " + phrases.getPlayingPhrase());
            host = hostName;
            hostLabel.setText("Host: " + host);
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
