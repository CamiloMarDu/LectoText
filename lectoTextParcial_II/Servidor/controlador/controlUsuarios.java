package controlador;

import control.DAO.usuariosDAO;

public class controlUsuarios {
usuariosDAO usuarios=new usuariosDAO();
public boolean verificar(String usuario, String contraseña, int ip, String estado) {
	return usuarios.consultarExistencia(usuario, contraseña, ip, estado);
}
}