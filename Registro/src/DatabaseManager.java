import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import javax.swing.*;

public class DatabaseManager implements ActionListener{

    private JTextField[] campos;

    public DatabaseManager(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        
        System.out.println("Ruta de base de datos: " + new java.io.File("ususarios.db").getAbsolutePath());
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:ususarios.db")) {
           System.out.println("Conexión exitosa a la base de datos");
            String sql = "INSERT INTO usuarios (id, nombre, apellido, idUsuario, correo, contraseña)" +
                          " VALUES (?, ?, ?, ?, ?, ?)";


                     
                          
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
               
                
                stmt.setInt(1, Integer.parseInt(campos[2].getText()));  // id (si es numérico)
                stmt.setString(2, campos[0].getText());  // nombre
                stmt.setString(3, campos[1].getText());  // apellido
                stmt.setString(4, campos[2].getText());  // idUsuario (si es texto)
                stmt.setString(5, campos[3].getText());  // correo
                stmt.setString(6, campos[4].getText());  // contraseña


                 int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "✅ Registro agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se pudo agregar el registro");
                }

            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro: " + e.getMessage());
        }
    }

    
}