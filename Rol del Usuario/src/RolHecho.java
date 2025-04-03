import java.awt.*;
import javax.swing.*;

public class RolHecho extends JFrame {
    
    public RolHecho(){
        setTitle("Rol Creado");
        setSize(350, 450);

        //Panel para el mensaje 
        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(27, 67, 50));
        setContentPane(fondo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Mensaje sobre el proceso finalizado 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel title = new JLabel("¡Tu Perfil ha sido actualizado!");
        title.setFont(new Font("Courier New", Font.BOLD, 18));
        title.setForeground(Color.WHITE);   
        add(title, gbc);


        setVisible(true);
        

    }
}
