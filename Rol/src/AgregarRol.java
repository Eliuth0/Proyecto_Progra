import java.awt.event.*;
//import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import javax.swing.*;

public class AgregarRol implements ActionListener{

    private JTextField[] campos;

    public AgregarRol(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

      //  String rolSeleccionado = campos[1].getText();
        
        System.out.println("Ruta de base de datos: " + new java.io.File("user.db").getAbsolutePath());
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:user.db")) {
           System.out.println("Conexión exitosa a la base de datos");
            String sql = "INSERT INTO user (idstudent, rol, vehicle, color, passsanger, bag, location, preferences, extra)" +
                          " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


                     
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

                stmt.setString(1, campos[0].getText());
                String rol = campos[1].getText();
                stmt.setString(2, rol);
                
                if(rol.equalsIgnoreCase("Conductor")) {
                    stmt.setString(3, campos[2].getText());
                    stmt.setString(4, campos[3].getText());
                    stmt.setString(5, campos[4].getText());
                    stmt.setString(6, campos[5].getText());
                    campos[6].setText("");
                    campos[7].setText("");
                    stmt.setString(9, campos[8].getText());
                } else if(rol.equalsIgnoreCase("Pasajero")) {

                    campos[2].setText("");
                    campos[3].setText("");
                    campos[4].setText("");
                    campos[5].setText("");
                    stmt.setString(7, campos[6].getText());
                    stmt.setString(8, campos[7].getText());
                    stmt.setString(9, campos[8].getText());
                }


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


