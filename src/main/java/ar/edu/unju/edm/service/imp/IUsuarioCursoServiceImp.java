package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.repository.UsuarioCursoRepository;
import ar.edu.unju.edm.service.IUsuarioCursoService;

@Service
public class IUsuarioCursoServiceImp implements IUsuarioCursoService{
	@Autowired
	UsuarioCurso usuarioCurso;
	
	@Autowired
	UsuarioCursoRepository usuarioCursoRepository;

	@Override
	public void guardarUsuarioCurso(UsuarioCurso usuarioCurso) {
		// TODO Auto-generated method stub
		usuarioCursoRepository.save(usuarioCurso);
	}

	@Override
	public void eliminarUsuarioCurso(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuarioCurso(UsuarioCurso usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioCurso> listarUsuariosCursos() {
		// TODO Auto-generated method stub
		return (List<UsuarioCurso>) usuarioCursoRepository.findAll();
	}

	@Override
	public UsuarioCurso buscarUsuarioCurso(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioCurso nuevoUsuarioCurso() {
		// TODO Auto-generated method stub
		return usuarioCurso;
	}

}
