import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class RolTest {


    @Test
    public void testActionPerformedConductor() {
        // Campos para conductor
        JTextField[] campos = crearCamposConductor();
        
      
        AgregarRol agregarRol = new AgregarRol(campos);
        agregarRol.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        // Verificar que los campos de pasajero esten llenos
        assertEquals("El campo ID debería estar lleno", "123", campos[0].getText());
        assertEquals("El campo Rol debería estar lleno", "Conductor", campos[1].getText());
        assertEquals("El campo Vehículo debería estar lleno", "Carro", campos[2].getText());
        assertEquals("El campo Color debería estar lleno", "Rojo", campos[3].getText());
        assertEquals("El campo Pasajero debería estar lleno", "3", campos[4].getText());
        assertEquals("El campo Bag debería estar lleno", "Si", campos[5].getText());
        assertEquals("El campo Extra debería estar lleno", "Música", campos[8].getText());
    }

    @Test
    public void testActionPerformedPasajero() {
        // Campos para pasajero
        JTextField[] campos = crearCamposPasajero();
        
      
        AgregarRol agregarRol = new AgregarRol(campos);
        agregarRol.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        // Verificar que los campos de conductor esten llenos
        assertEquals("El campo ID debería estar lleno", "678", campos[0].getText());
        assertEquals("El campo Rol debería estar lleno", "Pasajero", campos[1].getText());
        assertEquals("El campo Location debería estar lleno", "Centro", campos[6].getText());
        assertEquals("El campo Preferences debería estar lleno", "Ventana", campos[7].getText());
        assertEquals("El campo Extra debería estar lleno", "Música", campos[8].getText());
    }

    // Datos de prueba
    private JTextField[] crearCamposConductor() {
        JTextField[] campos = new JTextField[9];
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
        }
        
        campos[0].setText("123"); 
        campos[1].setText("Conductor"); 
        campos[2].setText("Carro"); 
        campos[3].setText("Rojo"); 
        campos[4].setText("3"); 
        campos[5].setText("Si"); 
        campos[8].setText("Música"); 
        
        return campos;
    }

    private JTextField[] crearCamposPasajero() {
        JTextField[] campos = new JTextField[9];
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
        }
        
        campos[0].setText("678"); 
        campos[1].setText("Pasajero");
        campos[6].setText("Centro"); 
        campos[7].setText("Ventana"); 
        campos[8].setText("Música"); 
        
        return campos;
    }


    // Test para verificar la conexión a la base de datos
    @Test
    public void testConectarExitoso() {
        Connection conexion = ConexionSQLite.conectar();
        assertNotNull("La conexión no debería ser null", conexion);
        
        try {
            assertFalse("La conexión no debería estar cerrada", conexion.isClosed());
            conexion.close();
        } catch (Exception e) {
            fail("No debería lanzar excepción al verificar el estado de la conexión");
        }
    }
}