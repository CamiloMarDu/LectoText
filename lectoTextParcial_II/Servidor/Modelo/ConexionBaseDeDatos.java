package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
	private static Connection cn = null;
    //(Poner la url de la base de datos correspondiente)
    private static String URLBD = "jdbc:mysql://localhost:3306/usuarios";
    private static String usuario = "root";
    private static String contrasena = "";

    public static Connection getConexion() throws SQLException {
        	cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        	
        return cn;
    }

    public static void desconectar() {
        cn = null;
    }
	}

