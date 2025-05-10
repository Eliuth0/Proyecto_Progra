import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class AplicacionUDLAP {
    private JFrame frame;
    private JComboBox<String> destinosBox;
    private JButton solicitarBtn;
    private JTextArea resultadoArea;
    private ArrayList<Conductor> conductores;

    public AplicacionUDLAP() {
        frame = new JFrame("UDLAP Uber");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Selecciona tu destino:");
        frame.add(label);

        String[] destinos = {"Centro de Cholula", "Angelópolis", "Paseo San Francisco", "Plaza Dorada", "Estrella de Puebla"};
        destinosBox = new JComboBox<>(destinos);
        frame.add(destinosBox);

        solicitarBtn = new JButton("Solicitar viaje");
        frame.add(solicitarBtn);

        resultadoArea = new JTextArea(5, 30);
        resultadoArea.setEditable(false);
        frame.add(new JScrollPane(resultadoArea));

        conductores = new ArrayList<>();
        conductores.add(new Conductor("Carlos Pérez", "Nissan Versa"));
        conductores.add(new Conductor("Ana Gómez", "Chevrolet Aveo"));
        conductores.add(new Conductor("Luis Martínez", "Volkswagen Jetta"));
        conductores.add(new Conductor("Sofía Rodríguez", "Toyota Corolla"));

        solicitarBtn.addActionListener((ActionEvent e) -> solicitarViaje());

        frame.setVisible(true);
    }

    private void solicitarViaje() {
        if (destinosBox.getSelectedItem() == null || conductores.isEmpty()) {
            resultadoArea.setText("Error: No se pudo asignar el viaje.");
            return;
        }

        String destinoSeleccionado = (String) destinosBox.getSelectedItem();
        Conductor conductorAsignado = conductores.get(new Random().nextInt(conductores.size()));

        Viaje viaje = new Viaje(destinoSeleccionado, conductorAsignado);
        resultadoArea.setText(viaje.getDetalles());
    }

}
