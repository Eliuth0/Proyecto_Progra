import java.awt.event.*;
import javax.swing.*;

public class AyudaUser implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evento) {
        String mensaje = "Instrucciones de Uso:\n\n" +
                         "Para AGREGAR un registro:\n" +
                         "   - Seleccione el rol que desee.\n" + 
                         "   - Llene todos los campos del formulario.\n" +
                         "   - Haga clic en el botón 'Agregar'.\n\n" +
                         "Todos los datos se almacenan en una base de datos SQLite llamada 'user.db'.";
        JOptionPane.showMessageDialog(null, mensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
}
