package ar.edu.unju.edm.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class CursoController {

	private static final Log GUSTAVO = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	ICursoService cursoService;
	
	@GetMapping("/nuevoCurso")
	public ModelAndView addCurso() {
		GUSTAVO.info("ingresando al metodo: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		ModelAndView modelView = new ModelAndView("formCurso");
		modelView.addObject("unCurso", cursoService.nuevoCurso());		
		return modelView;
	}

	@PostMapping(value="/guardarCurso", consumes = "multipart/form-data" )
	public ModelAndView saveCurso(@Valid @ModelAttribute("unCurso") Curso cursoNuevo, BindingResult resultado, @RequestParam("file") MultipartFile file) {			
		ModelAndView modelView = new ModelAndView();
		if (resultado.hasErrors()) {
			GUSTAVO.fatal("ERROR DE VALIDACION");			
			modelView.setViewName("formCurso");
			modelView.addObject("unCurso", cursoNuevo);			
			return modelView;
		}		
		try {
			byte[] content = file.getBytes();
			String base64 = Base64.getEncoder().encodeToString(content);
			cursoNuevo.setImagen(base64);
			cursoNuevo.setEstado(true);
			cursoService.guardarCurso(cursoNuevo);
		} catch (Exception e) {			
			modelView.addObject("formCursoErrorMessage", e.getMessage());
			modelView.addObject("unCurso", cursoService.nuevoCurso());
			GUSTAVO.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			modelView.setViewName("formCurso");
			return modelView;		
		}		
		
		modelView.addObject("formCursoErrorMessage", "Curso guardado correctamente");
		modelView.addObject("unCurso", cursoService.nuevoCurso());
		modelView.addObject("listaCursos", cursoService.listarCursos());
		modelView.setViewName("listadoCursos");
		return modelView;
		}
	
	@GetMapping("/listadoCursos")	
	public ModelAndView showCourses() {
		ModelAndView vista = new ModelAndView("listadoCursos");		
		vista.addObject("listaCursos", cursoService.listarCursos());		
		return vista;
	}
}