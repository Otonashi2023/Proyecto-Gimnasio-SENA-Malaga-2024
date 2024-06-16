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
@Table(name="tipo_ejercicio")
public class TipoEjercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_ejerc", nullable = false)
	private int codigo;
	
	@Column(name="nom_tipo_ejerc", length = 45, nullable=false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "tipo_ejercicio")
	private List<Ejercicio> ejercicio = new ArrayList<>();
	
	public TipoEjercicio() {
		super();
	}

	public TipoEjercicio(int codigo) {
		super();
		this.codigo = codigo;
	}

	public TipoEjercicio(String nombre, List<Ejercicio> ejercicio) {
		super();
		this.nombre = nombre;
		this.ejercicio = ejercicio;
	}

	public TipoEjercicio(int codigo, String nombre, List<Ejercicio> ejercicio) {
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
		return "TipoEjercicio [codigo=" + codigo + ", nombre=" + nombre + ", ejercicio=" + ejercicio + "]";
	}
	
}
