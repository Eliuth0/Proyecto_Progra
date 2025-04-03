import java.awt.*;
import javax.swing.*;

public class Reportar extends JFrame {
    public Reportar(){
        setTitle("Reporte Creado");
        setSize(350, 450);

        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(255, 36, 0));
        setContentPane(fondo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel title = new JLabel("¡Tu reporte ha sido enviado!");
        title.setFont(new Font("Courier New", Font.BOLD, 18));
        title.setForeground(Color.WHITE);   
        add(title, gbc);


        setVisible(true);

    }
}

