import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BuscarUsuario implements ActionListener {

    private JTextField[] campos;
    
    public BuscarUsuario(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String id = campos[0].getText();
        String contraseña = campos[1].getText();

        if (id.isEmpty() || contraseña.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar el ID y la contraseña.");
            return;
        }

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:ususarios.db")) {
            String sql = "SELECT * FROM usuarios WHERE idUsuario = ? AND contraseña = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, id);
                stmt.setString(2, contraseña);
                ResultSet resultado = stmt.executeQuery();

                if (resultado.next()) {
                    new Bienvenida();
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se encontró ningún registro con ese ID. Si no tiene cuenta registrese");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al buscar registro: " + e.getMessage());
        }


    
    
    }

    
}
