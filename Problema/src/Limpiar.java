import java.awt.event.*;
import javax.swing.*;

public class Limpiar implements ActionListener {
    private JTextField[] campos;

    public Limpiar(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
        JOptionPane.showMessageDialog(null, "🧹 Todos los campos han sido limpiados.");
    }
}
