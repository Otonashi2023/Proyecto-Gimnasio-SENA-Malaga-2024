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
@Table(name="formacion")
public class Formacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_formacion", nullable = false)
	private int codigo;
	
	@Column (name="nom_formacion", length = 70, nullable = false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "formacion")
	private List<Ficha> ficha = new ArrayList<>();

	public Formacion() {
		super();
	}

	public Formacion(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Formacion(String nombre, List<Ficha> ficha) {
		super();
		this.nombre = nombre;
		this.ficha = ficha;
	}

	public Formacion(int codigo, String nombre, List<Ficha> ficha) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ficha = ficha;
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
		return "Formacion [codigo=" + codigo + ", nombre=" + nombre + ", ficha=" + ficha + "]";
	}
		
}
