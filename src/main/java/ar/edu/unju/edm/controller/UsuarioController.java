	package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.util.ListaUsuarios;

@Controller
public class UsuarioController {
	private static final Log GUSTAVO = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	Usuario nuevoUsuario;
	
	@Autowired
	IUsuarioService usuarioService;
		
	@GetMapping("/nuevoUsuario")
	public ModelAndView addUser() {
		GUSTAVO.info("ingresando al metodo: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		ModelAndView modelView = new ModelAndView("usuarios");
		//modelView.addObject("index");
		modelView.addObject("unUsuario", nuevoUsuario);
		modelView.addObject("editMode",false);
		//modelView.addObject("formUsuarioErrorMessage","HOLA");
		
		return modelView;
	}
	
	//diferenciar Valid y Validated
	@PostMapping("/guardarUsuario")
	public String saveUser(@Valid @ModelAttribute("unUsuario") Usuario usuarioNuevo, BindingResult resultado, ModelMap model) {			
			// VERIFICACION DEL NOMBRE Y DNI	
		if (resultado.hasErrors()) {
			GUSTAVO.fatal("ERROR DE VALIDACION");			
			model.addAttribute("unUsuario", usuarioNuevo);			
			return "usuarios";
		}		
		try {
			usuarioService.guardarUsuario(usuarioNuevo);
		} catch (Exception e) {			
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("unUsuario", usuarioNuevo);
			GUSTAVO.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			return "usuarios";		
		}		
		
		model.addAttribute("formUsuarioErrorMessage", "Usuario guardado correctamente");
		model.addAttribute("unUsuario", nuevoUsuario);			
		return "usuarios";
		}
	
	@GetMapping("/listadoUsuario")	
	// opcion 1
	public ModelAndView showUser() {
		ModelAndView vista = new ModelAndView("getUsers");		
		vista.addObject("listaUsuario", usuarioService.listarUsuarios());	
		GUSTAVO.info("ingresando al metodo: cvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+usuarioService.listarUsuarios().get(0).getApellido());
		return vista;
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminar(@PathVariable Integer id, Model model) {	
		try {
		usuarioService.eliminarUsuario(id);
		}catch(Exception e) {
			GUSTAVO.error("encontrando: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			return "redirect:/nuevoUsuario";			
		}
		return "redirect:/listadoUsuario";
	}

	@GetMapping("/editarUsuario/{dni}")
	public ModelAndView ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="dni") Integer dni) throws Exception {
		//buscar usuario en el listado
		Usuario usuarioEncontrado = new Usuario();
		usuarioEncontrado = usuarioService.buscarUsuario(dni);	
		ModelAndView modelView = new ModelAndView("usuarios");
		modelView.addObject("unUsuario", usuarioEncontrado);
		GUSTAVO.error("saliendo del metodo: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+ usuarioEncontrado.getDni());
		modelView.addObject("editMode",true);		
		return modelView;
	}
	
	
	
	@PostMapping("/editarUsuario")
	public ModelAndView postEditarUsuario(@ModelAttribute("usuarioF") Usuario usuarioModificado) {		
				
				//model.addAttribute("usuarioF", usuario);
				//model.addAttribute("editMode", "false");
			//} catch (Exception e) {
			//	model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			//	model.addAttribute("userForm", usuario);
			//	model.addAttribute("editMode", "true");
			//}
		//}

		//model.addAttribute("usuarios", usuarioService.listarUsuario());
		usuarioService.modificarUsuario(usuarioModificado);
		ModelAndView vista = new ModelAndView("getUsers");		
		vista.addObject("listaUsuario", usuarioService.listarUsuarios());	
		vista.addObject("formUsuarioErrorMessage","Usuario Guardado Correctamente");
		return vista;
	}
}
