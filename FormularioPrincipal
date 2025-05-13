import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FormularioPrincipal {

    private static Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:basedatos_udlap.db"; 
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado correctamente a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conn;
    }

    private static void insertarUsuario(String id, String nombre) {
        String sql = "INSERT INTO usuarios(id, nombre) VALUES(?, ?)";

        try (Connection conn = conectar(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
            System.out.println("Usuario registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registro de Usuario:");
        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine();

        insertarUsuario(id, nombre);
    }
}
