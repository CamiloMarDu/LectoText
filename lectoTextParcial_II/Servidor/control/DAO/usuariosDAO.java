package control.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelo.ConexionBaseDeDatos;

/**
 * Esta clase proporciona métodos para acceder y manipular datos de usuarios en la base de datos.
 */
public class usuariosDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int estados;

    /**
     * Constructor de la clase usuariosDAO.
     */
    public usuariosDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Consulta si un usuario con la contraseña y dirección IP proporcionadas existe en la base de datos y está activo.
     *
     * @param usuario     El nombre de usuario.
     * @param contraseña  La contraseña del usuario.
     * @param ip          La dirección IP del usuario.
     * @param estado      El estado del usuario.
     * @return true si el usuario existe y está activo, false en caso contrario.
     */
    public Boolean consultarExistencia(String usuario, String contraseña, String ip, String estado) {
        String consulta = "SELECT * FROM `usuarios` WHERE `usuario` LIKE '" + usuario + "'";

        try {
            con = (Connection) ConexionBaseDeDatos.getConexion();
            st = con.createStatement();

            rs = st.executeQuery(consulta);
            while (rs.next()) {
                if ("false".equals(rs.getString("estado")) && contraseña.equals(rs.getString("contraseña")) && ip.equals(rs.getString("ip"))) {
                    estados = 1;
                } else {
                    estados = 0;
                }
            }

            st.close();
            ConexionBaseDeDatos.desconectar();
        } catch (SQLException ex) {
            // Manejo de excepciones
        }

        return estados == 1;
    }

    /**
     * Cambia el estado de un usuario en la base de datos.
     *
     * @param usuario El nombre de usuario.
     * @param estado  El nuevo estado del usuario.
     */
    public void cambiarEstado(String usuario, int estado) {
        String consulta = "UPDATE `usuarios` SET `estado`='" + estado + "' WHERE `usuario` LIKE '" + usuario + "'";
        try {
            con = ConexionBaseDeDatos.getConexion();
            st = con.createStatement();
            st.executeUpdate(consulta);
            st.close();
            ConexionBaseDeDatos.desconectar();

        } catch (SQLException ex) {
            // Manejo de excepciones
        }
    }
}
