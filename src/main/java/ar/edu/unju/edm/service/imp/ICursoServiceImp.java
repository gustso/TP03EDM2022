package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.repository.CursoRepository;
import ar.edu.unju.edm.service.ICursoService;

@Service
public class ICursoServiceImp implements ICursoService{

	@Autowired
	Curso nuevoCurso;
	@Autowired
	CursoRepository cursoRepository;
	
	@Override
	public Curso nuevoCurso() {
		// TODO Auto-generated method stub
		return nuevoCurso;
	}

	@Override
	public void guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		cursoRepository.save(curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCurso(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		//return (List<Curso>) cursoRepository.findAll();
		return cursoRepository.findByEstado(false);
	}

	@Override
	public Curso buscarCurso(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
