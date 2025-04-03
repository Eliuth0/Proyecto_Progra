import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reporte extends JFrame {

    public Reporte() {
        setTitle("Reportar Problema");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        add(new JLabel("Razón del Reporte:"), gbc);
        
        gbc.gridy = 1;
        String[] reasons = {"Mala higiene del vehículo", "Conducción Imprudente", "Falta de respeto", "Falta de puntualidad"};
        JComboBox<String> reasonsBox = new JComboBox<>(reasons);

        JPanel reasonsPanel = new JPanel();
        reasonsPanel.add(reasonsBox);
        add(reasonsPanel, gbc);

        // Evidencia
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JLabel titleLabel = new JLabel("Subir evidencias (opcional)");
        add(titleLabel, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        JButton subirButton = new JButton("Evidencia");
        subirButton.setForeground(Color.WHITE);
        subirButton.setBackground(new Color(255, 36, 0));
        add(subirButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
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
        gbc.gridy = 5;
        JLabel descriptionLabel = new JLabel("Comentarios adicionales sobre el incidente");
        add(descriptionLabel, gbc);

        // Área de texto para comentarios
        gbc.gridy = 7;
        gbc.gridwidth = 7;
        JTextArea introTextArea = new JTextArea(5, 30);
        introTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(new JScrollPane(introTextArea), gbc);


        gbc.gridy = 11;
        JButton reportButton = new JButton("Reportar");
        reportButton.setForeground(Color.WHITE);
        reportButton.setBackground(new Color(255, 36, 0));
        add(reportButton, gbc);

        reportButton.addActionListener((ActionEvent e) -> {
            new Reportar();
            dispose(); 
        });

        setVisible(true);
    }
}
