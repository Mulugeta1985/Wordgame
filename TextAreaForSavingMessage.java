
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
        JFrame frame = new JFrame("why i use BoxLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Create the JPanel
        JPanel panel = new JPanel();

        // Create the JTextArea
        JTextArea textArea = new JTextArea(14, 30); // 10 rows and 30 columns
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries

        if (GUI.isCheckBoxSelected) {
            textArea.setText(GUI.gameText);
        } else {
            textArea.setText(null);
        }
        // Add the JTextArea to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        textArea.setText(
                "Using BoxLayout in Swing provides a versatile and straightforward way to manage the layout of components within a container. BoxLayout allows for arranging components either vertically (Y_AXIS) or horizontally (X_AXIS), making it suitable for a wide range of UI designs.\n"
                        + "\n"
                        + "One of the key advantages of BoxLayout is its simplicity and flexibility in managing the alignment and sizing of components. It allows you to control how components are spaced and aligned within their container, whether you want them to be centered, left-aligned, right-aligned, or stretched to fill the available space. This control over alignment is particularly useful when designing interfaces that require a specific visual hierarchy or when components need to maintain consistent spacing.\n"
                        + "\n"
                        + "Moreover, BoxLayout dynamically adjusts its layout when the container is resized, ensuring that components are rearranged appropriately to fit within the new dimensions. This behavior is crucial for creating responsive and user-friendly interfaces where the layout adapts smoothly to changes in window size or screen resolution.\n"
                        + "\n"
                        + "In practice, BoxLayout is often used for creating vertical lists, horizontal toolbars, panels with aligned components, and other structured layouts where the order and alignment of components matter. It provides a straightforward API to achieve these layouts without the complexity of more advanced layout managers, making it accessible for developers looking to create clean and organized GUIs in Java Swing applications. Whether used alone or in combination with other layout managers like BorderLayout or GridLayout, BoxLayout remains a powerful tool for achieving precise control over the arrangement of UI components in Swing applications.");
        textArea.setEditable(false);

        // Add the JScrollPane to the JPanel
        panel.add(scrollPane);

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
