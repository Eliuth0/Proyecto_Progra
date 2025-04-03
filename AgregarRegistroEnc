import java.awt.event.*;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.*;

/**
 * Esta clase se encarga de agregar un nuevo registro a la base de datos SQLite.
 * Además, encripta el nombre y el apellido con SHA-256 antes de almacenarlos.
 */
public class AgregarRegistroEnc implements ActionListener {
    private JTextField[] campos; // Arreglo de campos del formulario

    public AgregarRegistroEnc(JTextField[] campos) {
        this.campos = campos;
    }

    /**
     * Método que encripta un texto usando el algoritmo SHA-256.
     * el algoritmo SHA-256 para encriptar el nombre y apellido. Este algoritmo funciona 
     * con un hash, lo que significa que no se puede revertir el proceso de encriptación.
     * Guardamos el hash en la base de datos, lo que permite verificar la identidad del usuario sin almacenar su información sensible.
     * En la busqueda, se compara el hash del nombre y apellido ingresados por el usuario con el hash almacenado en la base de datos.
     * @param texto El texto a encriptar.
     * @return Cadena hexadecimal con el hash generado.
     */
    private String encriptarSHA256(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");//// Obtenemos una instancia del algoritmo SHA-256
            byte[] hash = digest.digest(texto.getBytes("UTF-8")); // Convertimos el texto a bytes y generamos el hash
            StringBuilder hexString = new StringBuilder();//StringBuilder para almacenar el hash en formato hexadecimal

            // Convertimos los bytes en formato hexadecimal
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            // Si ocurre un error, devolvemos el texto original (no recomendado para producción)
            return texto;
        }
    }

    /**
     * Método que se ejecuta cuando el usuario hace clic en el botón "Agregar".
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:direcciones.db")) {
            // Sentencia SQL para insertar un nuevo registro
            String sql = "INSERT INTO addresses (firstname, lastname, address, city, stateorprovince, postalcode, country, emailaddress, homephone, faxnumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                // Encriptar nombre y apellido antes de insertar
                stmt.setString(1, encriptarSHA256(campos[0].getText()));
                stmt.setString(2, encriptarSHA256(campos[1].getText()));

                // Insertar el resto de los campos sin encriptar
                for (int i = 2; i < campos.length; i++) {
                    stmt.setString(i + 1, campos[i].getText());
                }

                // Ejecutar la inserción
                int filasInsertadas = stmt.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "Registro agregado con nombre y apellido encriptados.");
                } else {
                    JOptionPane.showMessageDialog(null, " No se pudo agregar el registro.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
        }
    }
}
