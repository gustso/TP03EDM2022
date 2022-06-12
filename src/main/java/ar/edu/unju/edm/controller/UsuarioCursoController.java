package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.service.IUsuarioCursoService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioCursoController {
	private static final Log GUSTAVO = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	IUsuarioCursoService usuarioCursoService;
	@Autowired
	IUsuarioService usuarioService;
	@Autowired
	ICursoService cursoService;	
	
	@GetMapping("/nuevaInscripcion")
	public ModelAndView addInscripcion() {
		GUSTAVO.info("ingresando al metodo: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		ModelAndView modelView = new ModelAndView("inscripcion");
		modelView.addObject("unaInscripcion", usuarioCursoService.nuevoUsuarioCurso());
		modelView.addObject("usuarios", usuarioService.listarUsuarios());
		modelView.addObject("cursos", cursoService.listarCursos());
		return modelView;
	}

	@PostMapping("/guardarInscripcion")
	public ModelAndView saveInscripcion(@Valid @ModelAttribute("unaInscripcion") UsuarioCurso usuarioCursoNuevo, BindingResult resultado) {			
			// VERIFICACION DEL NOMBRE Y DNI	
		ModelAndView modelView = new ModelAndView();
		if (resultado.hasErrors()) {
			GUSTAVO.fatal("ERROR DE VALIDACION");			
			modelView.setViewName("inscripcion");
			modelView.addObject("unaInscripcion", usuarioCursoNuevo);			
			return modelView;
		}		
		try {
			usuarioCursoService.guardarUsuarioCurso(usuarioCursoNuevo);
		} catch (Exception e) {			
			modelView.addObject("formUsuarioErrorMessage", e.getMessage());
			modelView.addObject("unUsuario", usuarioCursoService.nuevoUsuarioCurso());
			GUSTAVO.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			modelView.setViewName("inscripcion");
			return modelView;		
		}		
		
		modelView.addObject("formUsuarioErrorMessage", "Usuario guardado correctamente");
		modelView.addObject("unUsuario", usuarioCursoService.nuevoUsuarioCurso());
		modelView.setViewName("inscripcion");
		return modelView;
		}
}
