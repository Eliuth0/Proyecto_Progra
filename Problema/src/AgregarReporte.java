import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import javax.swing.*;

public class AgregarReporte implements ActionListener{

    private JTextField[] campos;

    public AgregarReporte(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        System.out.println("Ruta de base de datos: " + new java.io.File("ProblemaBasedeDatos.db").getAbsolutePath());
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:ProblemaBasedeDatos.db")) {
           System.out.println("Conexión exitosa a la base de datos");
            String sql = "INSERT INTO problem (idstudent, reason, extra)" +
                          " VALUES (?, ?, ?)";


                     
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, campos[0].getText());
                stmt.setString(2, campos[1].getText());
                stmt.setString(3, campos[2].getText());

                int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el registro");
                }
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro: " + e.getMessage());
        }
    }

    
}
