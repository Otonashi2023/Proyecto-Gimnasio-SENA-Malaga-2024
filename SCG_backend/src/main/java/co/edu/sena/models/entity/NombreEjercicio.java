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
@Table(name="nombre_ejercicio")
public class NombreEjercicio {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_nom_ejerc")
	private int codigo;
	
	@Column (name="nom_ejerc", length = 45, nullable= false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "nombre_ejercicio")
	private List<Ejercicio> ejercicio = new ArrayList<>();
	
	public NombreEjercicio() {
		super();
	}

	public NombreEjercicio(int codigo) {
		super();
		this.codigo = codigo;
	}

	public NombreEjercicio(String nombre, List<Ejercicio> ejercicio) {
		super();
		this.nombre = nombre;
		this.ejercicio = ejercicio;
	}

	public NombreEjercicio(int codigo, String nombre, List<Ejercicio> ejercicio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ejercicio = ejercicio;
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
		return "NombreEjercicio [codigo=" + codigo + ", nombre=" + nombre + ", ejercicio=" + ejercicio + "]";
	}
	
}
