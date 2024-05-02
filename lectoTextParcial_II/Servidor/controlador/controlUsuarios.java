package controlador;

import control.DAO.usuariosDAO;

/**
 * Esta clase proporciona métodos para controlar la autenticación de usuarios.
 */
public class controlUsuarios {
    private usuariosDAO usuarios = new usuariosDAO();

    /**
     * Verifica la existencia de un usuario en la base de datos y su estado.
     *
     * @param usuario     El nombre de usuario.
     * @param contraseña  La contraseña del usuario.
     * @param ip          La dirección IP del usuario.
     * @param estado      El estado del usuario.
     * @return true si el usuario existe y está activo, false en caso contrario.
     */
    public boolean verificar(String usuario, String contraseña, String ip, String estado) {
        return usuarios.consultarExistencia(usuario, contraseña, ip, estado);
    }
}

