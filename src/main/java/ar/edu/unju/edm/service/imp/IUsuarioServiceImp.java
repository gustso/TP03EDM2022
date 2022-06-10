package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.controller.UsuarioController;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.util.ListaUsuarios;

@Service
public class IUsuarioServiceImp implements IUsuarioService{

	private static final Log GUSTAVO = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	ListaUsuarios lista;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setEstado(true);
		usuarioRepository.save(usuario);
		//lista.getListed().add(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub		
		for (int i = 0; i < lista.getListed().size(); i++) {			
			if (lista.getListed().get(i).getDni().equals(id)) {				
				lista.getListed().get(i).setEstado(false);		
			}            
        }		
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		//usuario.setEstado(true);
		for (int i = 0; i < lista.getListed().size(); i++) {			
			if (lista.getListed().get(i).getDni().equals(usuario.getDni())) {
				GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				lista.getListed().set(i, usuario);			
			}            
        }
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> auxiliar = new ArrayList<>();
		/*
		 * GUSTAVO.info("ingresando al metodo: iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"); for
		 * (int i = 0; i < lista.getListed().size(); i++) {
		 * GUSTAVO.error("recorriendo: oooooooooooooooooooooooooooo"+lista.getListed().
		 * get(i).getDni());
		 * 
		 * if (lista.getListed().get(i).getEstado()==true) {
		 * //GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 * auxiliar.add(lista.getListed().get(i)); } }
		 */
		auxiliar=(List<Usuario>) usuarioRepository.findAll();
		return auxiliar;
	}

	

	@Override
	public Usuario buscarUsuario(Integer id) {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = new Usuario();
		for (int i = 0; i < lista.getListed().size(); i++) {
//			GUSTAVO.error("recorriendo: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+dni);
			
			if (lista.getListed().get(i).getDni().equals(id)) {
				//GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				usuarioEncontrado = lista.getListed().get(i);		
			}            
        }
		return usuarioEncontrado;
	}

}
