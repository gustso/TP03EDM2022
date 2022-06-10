package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UsuarioCurso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarioCurso;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dni")
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCurso")
	private Curso curso;
	private LocalDate fechaInscripcion;
	
	public UsuarioCurso() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdUsuarioCurso() {
		return idUsuarioCurso;
	}

	public void setIdUsuarioCurso(Integer idUsuarioCurso) {
		this.idUsuarioCurso = idUsuarioCurso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	
}
