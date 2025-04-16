import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reporte extends JFrame {

    public Reporte() {
        setTitle("Reportar Problema");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0; 
        add(new JLabel("ID del estudiante:"), gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 3;
        JTextField idTextField = new JTextField();
        idTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(idTextField, gbc);

        gbc.gridy = 2;
        add(new JLabel("Razón del Reporte:"), gbc);
    
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        JTextField reasonTextField = new JTextField();
        reasonTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(reasonTextField, gbc);


        // Evidencia
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JLabel titleLabel = new JLabel("Subir evidencias (opcional)");
        add(titleLabel, gbc);

        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        JButton subirButton = new JButton("Evidencia");
        subirButton.setForeground(Color.WHITE);
        subirButton.setBackground(new Color(255, 36, 0));
        add(subirButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JLabel etiqueta = new JLabel("Sin archivo");
        add(etiqueta, gbc);

        subirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            etiqueta.setText("¡El archivo ha sido subido!");
            }
         });


        // Comentarios
        gbc.gridy = 7;
        JLabel descriptionLabel = new JLabel("Comentarios adicionales sobre el incidente");
        add(descriptionLabel, gbc);

        // Área de texto para comentarios
        gbc.gridy = 8;
        gbc.gridwidth = 7;
        JTextArea introTextArea = new JTextArea(5, 30);
        introTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(new JScrollPane(introTextArea), gbc);


        gbc.gridy = 9;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JButton reportButton = new JButton("Reportar");
        reportButton.setForeground(Color.WHITE);
        reportButton.setBackground(new Color(255, 36, 0));
        
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String comentario = introTextArea.getText();
                JTextField introTextField = new JTextField(comentario);

                JTextField[] campos = {idTextField, reasonTextField, introTextField};
                new AgregarReporte(campos).actionPerformed(e);
            } 
        });
        
        add(reportButton, gbc);

        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JButton buscarButton = new JButton("Buscar");
        buscarButton.setForeground(Color.WHITE);
        buscarButton.setBackground(new Color(255, 36, 0));
        
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String comentario = introTextArea.getText();
                JTextField introTextField = new JTextField(comentario);

                JTextField[] campos = {idTextField, reasonTextField, introTextField};
                new BuscarReporte(campos).actionPerformed(e);
            } 
        });
        
        add(buscarButton, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JButton limpiarButton = new JButton("Limpiar");
        limpiarButton.setForeground(Color.WHITE);
        limpiarButton.setBackground(new Color(255, 36, 0));

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                String comentario = introTextArea.getText();
                JTextField introTextField = new JTextField(comentario);

                JTextField[] campos = {idTextField, reasonTextField, introTextField};
                new Limpiar(campos).actionPerformed(e);
            } 
        });
        
        add(limpiarButton, gbc);

        gbc.gridy = 10;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JButton ayudaButton = new JButton("Ayuda");
        ayudaButton.setForeground(Color.WHITE);
        ayudaButton.setBackground(new Color(255, 36, 0));
        ayudaButton.addActionListener(new Ayuda());
        add(ayudaButton, gbc);

        setVisible(true);
    }
}
