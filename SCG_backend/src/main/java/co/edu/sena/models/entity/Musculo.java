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
@Table(name="musculo")
public class Musculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_musculo", nullable = false)
	private int codigo;
	
	@Column(name="nom_musculo", length = 45, nullable=false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "musculo")
	private List<Ejercicio> ejercicio = new ArrayList<>();
	
	public Musculo() {
		super();
	}
	public Musculo(int codigo) {
		super();
		this.codigo = codigo;
	}
	public Musculo(String nombre, List<Ejercicio> ejercicio) {
		super();
		this.nombre = nombre;
		this.ejercicio = ejercicio;
	}
	public Musculo(int codigo, String nombre, List<Ejercicio> ejercicio) {
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
		return "Musculo [codigo=" + codigo + ", nombre=" + nombre + ", ejercicio=" + ejercicio + "]";
	}
	
}
