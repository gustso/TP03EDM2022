package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Curso;


@Service
public interface ICursoService {
	public Curso nuevoCurso();
	public void guardarCurso(Curso curso);
	public void eliminarCurso(Integer id);
	public void modificarCurso(Curso curso);
	public List<Curso> listarCursos(); 
	public Curso buscarCurso(Integer id);
}
