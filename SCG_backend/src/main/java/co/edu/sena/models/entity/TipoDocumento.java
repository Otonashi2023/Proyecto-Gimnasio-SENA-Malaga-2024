package co.edu.sena.models.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_tipo_docum", nullable = false)
	private int codigo;
	
	@Column (name="nom_documento", length = 45, nullable = false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "tipo_documento")
	private List<Persona> persona = new ArrayList<>();

	public TipoDocumento() {
		super();
	}

	public TipoDocumento(int codigo) {
		super();
		this.codigo = codigo;
	}

	public TipoDocumento(String nombre, List<Persona> persona) {
		super();
		this.nombre = nombre;
		this.persona = persona;
	}

	public TipoDocumento(int codigo, String nombre, List<Persona> persona) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.persona = persona;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoDocumento [codigo=" + codigo + ", nombre=" + nombre + ", persona=" + persona + "]";
	}
	
}
