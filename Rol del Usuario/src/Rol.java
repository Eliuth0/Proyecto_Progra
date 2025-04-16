import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rol extends JFrame {

    private JComboBox<String> tipoBox;
    private JTextField colorTextField;
    private JTextField pasajerosTextField;
    private JComboBox<String> equipajeBox;
    private JTextField ubiTextField;
    private JTextField preTextField;  
    

    public Rol() {
        setTitle("Rol");
        setSize(450, 550);
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

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        JLabel idLabel = new JLabel("Id del Estudiante:");
        add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        JTextField idTextField = new JTextField();
        idTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(idTextField, gbc);

        // Rol de usuario
        gbc.gridy = 2;
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
        gbc.gridy = 3;
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
                    tipoBox = new JComboBox<>(vehículoStrings); 
                    rol2Panel.add(tipoBox, gbc);

                    //Título de color vehículo 
                    gbc.gridy = 1;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JLabel colorLabel = new JLabel("Color del vehículo:");
                    rol2Panel.add(colorLabel, gbc);
            
                    //Text Field para ingresar el color
                    gbc.gridx = 1;
                    colorTextField =  new JTextField();
                    colorTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    rol2Panel.add(colorTextField, gbc);


                     //Título para Cantidad de pasajeros
                     gbc.gridx = 0;
                     gbc.gridy = 2;
                     gbc.gridwidth = 1;
                     JLabel texto = new JLabel("Cantidad de Pasajeros");
                     rol2Panel.add(texto, gbc);
 
                     //JTextField para cantidad de pasajeros
                     gbc.gridx = 1;
                     pasajerosTextField = new JTextField();
                     pasajerosTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                     rol2Panel.add(pasajerosTextField, gbc);

                      //título de lugar de equipaje
                    gbc.gridy = 3;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JLabel equipajeLabel = new JLabel("¿Lugar para equipaje?:");
                    rol2Panel.add(equipajeLabel, gbc);
                  
                    //String para equipaje y JComboBox para escoger entre opciones
                    gbc.gridx = 1;
                    String[]equipajeStrings = {"Si", "No"};
                    equipajeBox = new JComboBox<>(equipajeStrings); 
                    rol2Panel.add(equipajeBox, gbc);

                    //Butón para subir la licencia
                    gbc.gridy = 4;
                    gbc.gridwidth = 1;
                    gbc.gridx = 0;
                    JButton subirButton = new JButton("Subir licencia");
                    subirButton.setForeground(Color.WHITE);
                    subirButton.setBackground(new Color(27, 67, 50));
                    rol2Panel.add(subirButton, gbc);

                    //Mensaje que se muestra antes de presionar el butón
                    gbc.gridx = 0;
                    gbc.gridy = 5;
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
                    gbc.gridwidth = 5;
                    JLabel texto = new JLabel("Ubicación de inicio");
                    rol2Panel.add(texto, gbc);

                    //Área de texto para escribir la ubicación 
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    ubiTextField = new JTextField();
                    ubiTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    rol2Panel.add(ubiTextField, gbc);
                    
                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    gbc.gridwidth = 1;
                    JLabel preferencia = new JLabel("Preferencia extra (opcional)");
                    rol2Panel.add(preferencia, gbc);

                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.gridwidth = 5;
                    preTextField =  new JTextField();
                    preTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    rol2Panel.add(new JScrollPane(preTextField), gbc);

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

        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){


                String rolSeleccionado = (String)rolBox.getSelectedItem();
                
                String tipoValor = rolSeleccionado.equals("Conductor") && tipoBox != null ?
                                    (String)tipoBox.getSelectedItem() : ""; 
                
                String colorValor = rolSeleccionado.equals("Conductor") && tipoBox != null ?
                                    colorTextField.getText() : ""; 

                String cantidadValor = rolSeleccionado.equals("Conductor") && tipoBox != null ?
                                    pasajerosTextField.getText() : ""; 
                                    
                String equipajeValor = rolSeleccionado.equals("Conductor") && tipoBox != null ?
                                    (String)equipajeBox.getSelectedItem() : ""; 
                
                String ubicacionValor = rolSeleccionado.equals("Pasajero") && tipoBox != null ?
                                    ubiTextField.getText() : ""; 

                String preferenciasValor = rolSeleccionado.equals("Conductor") && tipoBox != null ?
                                    preTextField.getText() : "";
                                    
                String comentario = introTextArea.getText();
                JTextField introTextField = new JTextField(comentario);

                JTextField[] campos = { 
                    idTextField, 
                    new JTextField(rolSeleccionado),
                    new JTextField(tipoValor),
                    new JTextField(colorValor),
                    new JTextField(cantidadValor),
                    new JTextField(equipajeValor),
                    new JTextField(ubicacionValor),
                    new JTextField(preferenciasValor),
                    introTextField   };

                new AgregarRol(campos).actionPerformed(e);

                
            } 
        });
        
        add(finalizarButton, gbc);

        setVisible(true); }
          
            
}

