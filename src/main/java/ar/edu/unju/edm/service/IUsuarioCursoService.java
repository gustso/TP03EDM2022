package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCurso;


@Service
public interface IUsuarioCursoService {
	public UsuarioCurso nuevoUsuarioCurso();
	public void guardarUsuarioCurso(UsuarioCurso usuarioCurso);
	public void eliminarUsuarioCurso(Integer id);
	public void modificarUsuarioCurso(UsuarioCurso usuario);
	public List<UsuarioCurso> listarUsuariosCursos(); 
	public UsuarioCurso buscarUsuarioCurso(Integer id);
}
