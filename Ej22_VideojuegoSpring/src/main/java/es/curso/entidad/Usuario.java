package es.curso.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@Scope("prototype")

@Entity
@Table(name="usuarios")
@SessionScope
public class Usuario {
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	@Id
	@NotBlank
	private String usuario;
	@NotBlank
	private String contrasenia;
	
	@Transient
	private List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
	
	public String getUsuario() {
		return usuario;
	}
	public Usuario() {
		
	}
	public Usuario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void addJuego(Videojuego videojuego) {
		listaVideojuegos.add(videojuego);
	}
	public List<Videojuego> getListaVideojuegos() {
		return listaVideojuegos;
	}
	public void setListaVideojuegos(List<Videojuego> listaVideojuegos) {
		this.listaVideojuegos = listaVideojuegos;
	}
}
