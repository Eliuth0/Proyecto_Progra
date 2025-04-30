import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bienvenida extends JFrame {
    
    public Bienvenida() {
        // Configuración de la ventana
        setTitle("Bienvenido a UDLAP Uber");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Panel para poner los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta de bienvenida
        JLabel etiqueta = new JLabel("¡Bienvenido a UDLAP Uber!", JLabel.CENTER);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(etiqueta, BorderLayout.CENTER);

        // Botón de continuar
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(botonContinuar, BorderLayout.SOUTH);

        // Acción del botón
        botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AplicacionUDLAP principal = new AplicacionUDLAP();
                principal.setVisible(true);
                dispose(); // Cierra la ventana de bienvenida
            }
        });

        // Agregas el panel a la ventana
        add(panel);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de bienvenida
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setVisible(true);
    }
}
