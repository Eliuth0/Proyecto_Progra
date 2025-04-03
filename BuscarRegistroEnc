import java.awt.event.*;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.*;

/**
 * Clase que permite buscar registros en la base de datos SQLite
 * usando SHA-256 para comparar nombre y apellido encriptados.
 */
public class BuscarRegistroEnc implements ActionListener {
    private JTextField[] campos;

    public BuscarRegistroEnc(JTextField[] campos) {
        this.campos = campos;
    }

    /**
     * Encripta el texto usando el algoritmo SHA-256.
     * @param texto El texto a convertir.
     * @return Cadena en hexadecimal con el hash del texto.
     */
    private String encriptarSHA256(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            return texto;
        }
    }

    /**
     * Acción que se ejecuta al presionar el botón de búsqueda.
     * Busca por nombre y apellido encriptados.
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        String nombre = campos[0].getText();
        String apellido = campos[1].getText();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre y apellido para buscar.");
            return;
        }

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:direcciones.db")) {
            // Usar SHA-256 para buscar los campos encriptados
            String sql = "SELECT * FROM addresses WHERE firstname = ? AND lastname = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, encriptarSHA256(nombre));
                stmt.setString(2, encriptarSHA256(apellido));

                ResultSet resultado = stmt.executeQuery();

                if (resultado.next()) {
                    for (int i = 2; i < campos.length; i++) {
                        campos[i].setText(resultado.getString(i + 1));
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
