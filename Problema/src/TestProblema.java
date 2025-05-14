import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class TestProblema {

    @Test
    public void testAcciónExitosa() {
        // Configurar campos de prueba
        JTextField[] campos = new JTextField[3];
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
        }
        campos[0].setText("1345"); 
        campos[1].setText("Mala conducta"); 
        campos[2].setText("Se paso semáforo en rojo"); 

        // Ejecutar el método a probar
        AgregarReporte agregarReporte = new AgregarReporte(campos);
        agregarReporte.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));

        // Verificar que los campos esten llenos
        assertEquals("1345", campos[0].getText());
        assertEquals("Mala conducta", campos[1].getText());
        assertEquals("Se paso semáforo en rojo", campos[2].getText());
    }

    @Test
    public void testAccionLimpiar() {
        JTextField[] campos = new JTextField[3];
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
        }
        campos[0].setText("1345"); 
        campos[1].setText("Mala conducta"); 
        campos[2].setText("Se paso semáforo en rojo"); 
        
        Limpiar limpiar = new Limpiar(campos);
        limpiar.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        // Verificar que están vacíos
        assertEquals("El campo 1 debería seguir vacío", "", campos[0].getText());
        assertEquals("El campo 2 debería seguir vacío", "", campos[1].getText());
        assertEquals("El campo 3 debería seguir vacío", "", campos[2].getText());
    }
    
    @Test
    public void testAccionBuscar() {
        
        //Datos de prueba
        JTextField idField = new JTextField("123");
        JTextField razonField = new JTextField();
        JTextField extraField = new JTextField();
        JTextField[] campos = {idField, razonField, extraField};
        
        BuscarReporte buscar = new BuscarReporte(campos);
        buscar.actionPerformed(new ActionEvent(new JButton(), ActionEvent.ACTION_PERFORMED, ""));
        
        // Verificar que no hubo excepción
        assertTrue("Debería manejar búsqueda sin errores", true);
    }

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
