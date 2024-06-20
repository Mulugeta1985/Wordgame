/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 import java.awt.Dimension;
 import java.awt.Toolkit;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JOptionPane;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JTextArea;
 import javax.swing.SwingUtilities;
 
 /**
  *
  * @author pc
  */
 public class TextAreaForSavingMessage {
 
     public TextAreaForSavingMessage() {
 
         // Create the JFrame
         JFrame frame = new JFrame("Write Your Message");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 300);
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
         // Create the JPanel
         JPanel panel = new JPanel();
 
         // Create the JTextArea
         JTextArea textArea = new JTextArea(10, 30);  // 10 rows and 30 columns
         textArea.setLineWrap(true);  // Enable line wrapping
         textArea.setWrapStyleWord(true);  // Wrap at word boundaries
 
        
 
         if(GUI.isCheckBoxSelected){
              textArea.setText(GUI.gameText);
         }else{
              textArea.setText(null);
         }
         // Add the JTextArea to a JScrollPane
         JScrollPane scrollPane = new JScrollPane(textArea);
         JButton button = new JButton("Submit");
 
         // Add an ActionListener to the button
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 GUI.gameText = textArea.getText();
                 // Print the text from the JTextArea to the console when the button is clicked
                 frame.dispose();
             }
         });
 
         textArea.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                
                 if (GUI.isCheckBoxSelected == false) {
                     textArea.setText(null);
          
                 }
 
             }
         });
 
         // Add the JScrollPane to the JPanel
         panel.add(scrollPane);
         panel.add(button);
         // Create the JButton
 
         // Add the JPanel to the JFrame
         frame.add(panel);
 
         // Make the frame visible
         frame.setVisible(true);
           frame.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
               
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 
             }
         });
     }
 }
 
