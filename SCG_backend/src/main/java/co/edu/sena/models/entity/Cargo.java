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
@Table(name="cargo")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_cargo", nullable = false)
	private int codigo;
	
	@Column (name="nom_cargo", length = 45, nullable = false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "cargo")
	private List<Personal> personal = new ArrayList<>();

	public Cargo() {
		super();
	}

	public Cargo(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Cargo(String nombre, List<Personal> personal) {
		super();
		this.nombre = nombre;
		this.personal = personal;
	}

	public Cargo(int codigo, String nombre, List<Personal> personal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.personal = personal;
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
		return "Cargo [codigo=" + codigo + ", nombre=" + nombre + ", personal=" + personal + "]";
	}
	
}
