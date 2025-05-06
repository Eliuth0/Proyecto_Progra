import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {

    public LoginFrame() {
        setTitle("Ingresar");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(15);
        add(idField, gbc);

        // Etiqueta y campo de contraseña
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        // Botón de Login
        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton loginButton = new JButton("INGRESAR");
        add(loginButton, gbc);

        // Enlace de "Forgot password?"
        gbc.gridx = 1;
        JLabel forgotPassword = new JLabel("<html><a href='#'>Forgot password?</a></html>");
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(forgotPassword, gbc);

        // Botón de Registro (Register)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton registerButton = new JButton("REGISTER");
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(27, 67, 50)); //cambiar color 
        add(registerButton, gbc);

        // Acción del botón Register para abrir SignUpFrame
        registerButton.addActionListener((ActionEvent e) -> {
            new SignUpFrame();
            dispose(); // Cierra la ventana actual
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JTextField[] campos = {idField, new JTextField(new String(passwordField.getPassword()))};
                new BuscarUsuario(campos).actionPerformed(e);
            }
        }
        );

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
