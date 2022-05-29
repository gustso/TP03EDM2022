package ar.edu.unju.edm.util;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Usuario;

@Component
public class ListaUsuarios {
	//Attributes
	private static List<Usuario> listed = new ArrayList<>(); 

	//Constructors
	public ListaUsuarios() {
	}

	//Getters and Setters
	public List<Usuario> getListed() {
		return listed;
	}

	public void setListed(List<Usuario> listed) {
		this.listed = listed;
	}

}

