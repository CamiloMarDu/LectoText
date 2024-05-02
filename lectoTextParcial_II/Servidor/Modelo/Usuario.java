package Modelo;

public class Usuario {
    private String usuario;
    private char[] contraseña;
    private String ip;
    private String estado;

    public Usuario(String usuario, char[] contraseña, String ip, String estado) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ip = ip;
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getContraseña() {
        return contraseña;
    }

    public void setContraseña(char[] contraseña) {
        this.contraseña = contraseña;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene una copia de la contraseña.
     * @return Una copia de la contraseña.
     */
    public char[] getCopyOfContraseña() {
        if (contraseña != null) {
            return contraseña.clone();
        } else {
            return new char[0];
        }
    }

    /**
     * Borra la contraseña almacenada en memoria.
     */
    public void clearContraseña() {
        if (contraseña != null) {
            for (int i = 0; i < contraseña.length; i++) {
                contraseña[i] = '\0';
            }
        }
    }
}
