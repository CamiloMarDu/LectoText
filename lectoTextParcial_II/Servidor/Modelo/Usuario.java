package Modelo;

public class Usuario {
	String usuario;
	String contraseña;
	String ip;
	String estado;
	public Usuario(String usuario, String contraseña, String ip, String estado) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.ip=ip;
		this.estado=estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
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
}
