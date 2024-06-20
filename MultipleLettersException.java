import javax.swing.JOptionPane;

public class MultipleLettersException extends Exception {
        @Override
        public String getMessage() {
                JOptionPane.showMessageDialog(null, "More than one letter was entered");
                return "More than one letter was entered";
        }
}