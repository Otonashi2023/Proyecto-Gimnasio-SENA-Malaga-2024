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
@Table(name="genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_genero", nullable = false)
	private int codigo;
	
	@Column (name="nom_genero", length = 45, nullable = false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "genero")
	private List<FichaAntropo> fichaantropo = new ArrayList<>();

	public Genero() {
		super();
	}

	public Genero(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Genero(String nombre, List<FichaAntropo> fichaantropo) {
		super();
		this.nombre = nombre;
		this.fichaantropo = fichaantropo;
	}

	public Genero(int codigo, String nombre, List<FichaAntropo> fichaantropo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fichaantropo = fichaantropo;
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
		return "Genero [codigo=" + codigo + ", nombre=" + nombre + ", fichaantropo=" + fichaantropo + "]";
	}
	
}
