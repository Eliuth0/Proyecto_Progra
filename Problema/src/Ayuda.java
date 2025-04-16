import java.awt.event.*;
import javax.swing.*;

public class Ayuda implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evento) {
        String mensaje = "Instrucciones de Uso:\n\n" +
                         "1. Para AGREGAR un registro:\n" +
                         "   - Llene todos los campos del formulario.\n" +
                         "   - Haga clic en el botón 'Agregar'.\n\n" +
                         "2. Para BUSCAR un registro:\n" +
                         "   - Ingrese el ID.\n" +
                         "   - Presione 'Buscar'.\n\n" +
                         "3. Para LIMPIAR el formulario:\n" +
                         "   - Presione el botón 'Limpiar'.\n\n" +
                         "Todos los datos se almacenan en una base de datos SQLite llamada 'problem.db'.";
        JOptionPane.showMessageDialog(null, mensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
}