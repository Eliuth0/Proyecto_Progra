import static org.junit.Assert.*;
import org.junit.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class TestRegistro {
    @Test
    public void testConDatosValidos() {
        
        JTextField[] campos = new JTextField[5];
        campos[0] = new JTextField("Juan");
        campos[1] = new JTextField("Pérez");
        campos[2] = new JTextField("123");
        campos[3] = new JTextField("juan@example.com");
        campos[4] = new JTextField("password123");

        DatabaseManager dbManager = new DatabaseManager(campos);
        dbManager.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));

        assertEquals("Juan", campos[0].getText());
        assertEquals("Pérez", campos[1].getText());
        assertEquals("123", campos[2].getText());
    
    }

    @Test
    public void testBusquedaNoExitosa() {
        
        JTextField idField = new JTextField("usuario123");
        JTextField passField = new JTextField("password123");
        JTextField[] campos = {idField, passField};
        
        BuscarUsuario buscarUsuario = new BuscarUsuario(campos);
        buscarUsuario.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        assertEquals("usuario123", idField.getText());
        assertEquals("password123", passField.getText());
    }

    @Test
    public void testBusquedaExitosa() {
        
        JTextField idField = new JTextField("123");
        JTextField passField = new JTextField("password123");
        JTextField[] campos = {idField, passField};
        
        BuscarUsuario buscarUsuario = new BuscarUsuario(campos);
        buscarUsuario.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        assertEquals("123", idField.getText());
        assertEquals("password123", passField.getText());
    }

    @Test
    public void testConectarExitosa() {
        Connection conexion = ConexionSQLite.conectar();
        
        // Verificar que se obtuvo una conexión
        assertNotNull("La conexión no debería ser null", conexion);
        
        try {
            // Verificar que la conexión está abierta
            assertFalse("La conexión debería estar abierta", conexion.isClosed());
            
            // Cerrar la conexión después de la prueba
            conexion.close();
        } catch (SQLException e) {
            fail("No debería lanzar excepción al verificar el estado de la conexión");
        }
    }


    
}










    

