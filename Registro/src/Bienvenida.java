import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bienvenida extends JFrame {
    
    public Bienvenida() {
        // Configuración de la ventana
        setTitle("Bienvenido a Mobility UDLAP");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Panel para poner los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta de bienvenida
        JLabel etiqueta = new JLabel("¡Bienvenido a Mobility UDLAP!", JLabel.CENTER);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(etiqueta, BorderLayout.CENTER);

        // Agregas el panel a la ventana
        add(panel);

        setVisible(true);
    }
}