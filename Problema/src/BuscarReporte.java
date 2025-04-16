import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BuscarReporte implements ActionListener {
    private JTextField[] campos;

    public BuscarReporte(JTextField[] campos) {
        this.campos = campos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String id = campos[0].getText();
        

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar id para buscar.");
            return;
        }

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:ProblemaBasedeDatos.db")) {
            String sql = "SELECT * FROM problem WHERE idstudent = ? ";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, id);
                ResultSet resultado = stmt.executeQuery();

                if (resultado.next()) {
                    for (int i = 2; i < campos.length; i++) {
                        campos[i-1].setText(resultado.getString(i + 1));
                    }
                    JOptionPane.showMessageDialog(null, "✅ Registro encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "⚠️ No se encontró ningún registro con ese nombre y apellido.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error al buscar registro: " + e.getMessage());
        }
    }
} 
