package ar.edu.unju.edm.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	private String mail;
	private String contrasena;
	@NotEmpty
	private String apellido;
	@Max (value = 99999999, message="DNI debe ser menor que 99999999")
	@Min(value = 1000000, message="DNI debe ser mayor que 1000000")
	private Integer dni;
	private Boolean estado;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}	

}
