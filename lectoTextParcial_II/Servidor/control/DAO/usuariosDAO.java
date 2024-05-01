package control.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Modelo.ConexionBaseDeDatos;





public class usuariosDAO {
	 private Connection con;
	    private Statement st;
	    private ResultSet rs;
	    private int estados;
	    public usuariosDAO() {
	        con = null;
	        st = null;
	        rs = null;
	    }

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
	           
	        }

	        return estados == 1;
	    }

	    public void cambiarEstado(String usuario, int estado) {
	        String consulta = "UPDATE `usuarios` SET `estado`='" + estado + "' WHERE `usuario` LIKE '" + usuario + "'";
	        try {
	            con = ConexionBaseDeDatos.getConexion();
	            st = con.createStatement();
	            st.executeUpdate(consulta);
	            st.close();
	            ConexionBaseDeDatos.desconectar();

	        } catch (SQLException ex) {

	        }
	    }
	}