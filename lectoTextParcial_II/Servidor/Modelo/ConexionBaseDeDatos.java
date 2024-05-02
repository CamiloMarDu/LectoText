package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para establecer la conexión con la base de datos.
 */
public class ConexionBaseDeDatos {
    private static Connection cn = null;
    // URL de la base de datos
    private static String URLBD = "jdbc:mysql://localhost:3306/usuarios_lector_texto";
    private static String usuario = "root";
    private static String contrasena = "";

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si hay un error al establecer la conexión.
     */
    public static Connection getConexion() throws SQLException {
        cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        return cn;
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public static void desconectar() {
        cn = null;
    }
}


