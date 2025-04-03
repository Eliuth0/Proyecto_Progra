import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rol extends JFrame {
    

    public Rol() {
        setTitle("Rol");
        setSize(350, 450);
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
        JLabel title = new JLabel("Bienvenido a Mobility UDLAP", SwingConstants.LEFT);
        title.setFont(new Font("Courier New", Font.BOLD, 18));
        title.setForeground(new Color(27, 67, 50)); // color verde
        add(title, gbc);

        // Rol de usuario
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Rol:"), gbc);
        gbc.gridx = 1;
        String[] rolStrings = {"Conductor", "Pasajero"};
        JComboBox<String> rolBox = new JComboBox<>(rolStrings); 
        JPanel rolPanel = new JPanel();
        rolPanel.add(rolBox);
        add(rolPanel, gbc);

        //Panel para el rol
        JPanel rol2Panel = new JPanel();
        rol2Panel.setLayout(new GridBagLayout()); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(rol2Panel, gbc);

    
        rolBox.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {

                String rolSeleccionado = (String) rolBox.getSelectedItem();
                rol2Panel.removeAll();

                //if else para cuando se escoge un rol salen las preguntas correspondientes
                if ("Conductor".equals(rolSeleccionado)) {

                    //título de tipo de vehículo
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JLabel tipoLabel = new JLabel("Tipo de vehículo:");
                    rol2Panel.add(tipoLabel, gbc);
                  
                    //String para tipos de vehículos y JComboBox para escoger entre opciones
                    gbc.gridx = 1;
                    String[]vehículoStrings = {"Carro", "Camioneta", "Moto"};
                    JComboBox<String> tipoBox = new JComboBox<>(vehículoStrings); 
                    rol2Panel.add(tipoBox, gbc);

                    //Título de color vehículo 
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JLabel colorLabel = new JLabel("Color del vehículo:");
                    rol2Panel.add(colorLabel, gbc);
            
                    //String para color y JComboBox para escoger entre las opciones 
                    gbc.gridx = 1;
                    String[]colorStrings = {"Negro", "Gris", "Rojo", "Azul"};
                    JComboBox<String> colorBox = new JComboBox<>(colorStrings); 
                    rol2Panel.add(colorBox, gbc);

                    //Butón para subir la licencia
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JButton subirButton = new JButton("Subir licencia");
                    subirButton.setForeground(Color.WHITE);
                    subirButton.setBackground(new Color(27, 67, 50));
                    rol2Panel.add(subirButton, gbc);

                    //Mensaje que se muestra antes de presionar el butón
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.gridwidth = 2;
                    JLabel etiqueta = new JLabel("Sin archivo");
                    rol2Panel.add(etiqueta, gbc);

                    //Acción para mostrar mensaje después de presionar el botón 
                    subirButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            etiqueta.setText("¡El archivo ha sido subido!");
                        }
                    });

                
                } else if ("Pasajero".equals(rolSeleccionado)) {
                  
                    //Título para Ubicación de Inicio 
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 1;
                    JLabel texto = new JLabel("Ubicación de inicio");
                    rol2Panel.add(texto, gbc);

                    //Área de texto para escribir la ubicación 
                    gbc.gridx = 3;
                    gbc.gridwidth = 5;
                    JTextArea introTextArea = new JTextArea(2, 15);
                    introTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    rol2Panel.add(new JScrollPane(introTextArea), gbc);
                    
                }

                rol2Panel.revalidate(); 
                rol2Panel.repaint();

            }
        });


        //Texto para datos adicionales 
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JLabel texto = new JLabel("Introduce datos adicionales (opcional)");
        add(texto, gbc);

        //Área de texto para los datos adicionales 
        gbc.gridy = 5;
        gbc.gridwidth = 7;
        JTextArea introTextArea = new JTextArea(5, 30);
        introTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(new JScrollPane(introTextArea), gbc);
     
        //Butón para finalizar los ajustes 
        gbc.gridy = 7;
        JButton finalizarButton = new JButton("Finalizar");
        finalizarButton.setForeground(Color.WHITE);
        finalizarButton.setBackground(new Color(27, 67, 50));
        add(finalizarButton, gbc);

        //Al presionar el boton crea una ventana para mandar mensaje 
        finalizarButton.addActionListener((ActionEvent e) -> {
            new RolHecho();
            dispose(); 
        });

        setVisible(true); }
          
            
}

