import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpFrame extends JFrame {

    public SignUpFrame() {
        setTitle("Registro de Usuario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel title = new JLabel("Registro de Usuario", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, gbc);

        // Nombre y Apellido
        gbc.gridy = 1;
        gbc.gridwidth = 0;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 0;
        JTextField firstNameField = new JTextField(20);
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        JTextField lastNameField = new JTextField(20);
        add(lastNameField, gbc);

         // ID
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(new JLabel("ID:"), gbc); 
        gbc.gridx = 0;
        gbc.gridy = 6;
        JTextField IDField = new JTextField(20);
        add(IDField, gbc);


        // Correo electrónico
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(new JLabel("Correo electrónico:"), gbc); 
        gbc.gridx = 0;
        gbc.gridy = 8;
        JTextField emailField = new JTextField(20);
        add(emailField, gbc);

        // Contraseña

        gbc.gridy = 9;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        JPasswordField passwordField = new JPasswordField(20);
        add(passwordField, gbc);

        // Botón de Registro
        gbc.gridy = 11;
        JButton signUpButton = new JButton("Registrarse");
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(27, 67, 50)); 
        add(signUpButton, gbc);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JTextField[] campos = {firstNameField, lastNameField, IDField, emailField, passwordField};
                new DatabaseManager(campos).actionPerformed(e);
            }
        }
        );

        setVisible(true);
    }
}