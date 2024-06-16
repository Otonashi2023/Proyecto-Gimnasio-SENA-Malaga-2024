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
@Table(name="tipo_rutina")
public class TipoRutina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_rutina", nullable = false)
	private int codigo;
	
	@Column(name="nom_rutina", length = 45, nullable=false)
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "tipo_rutina")
	private List<Rutina> rutina = new ArrayList<>();
	
	public TipoRutina() {
		super();
	}

	public TipoRutina(int codigo) {
		super();
		this.codigo = codigo;
	}

	public TipoRutina(String nombre, List<Rutina> rutina) {
		super();
		this.nombre = nombre;
		this.rutina = rutina;
	}

	public TipoRutina(int codigo, String nombre, List<Rutina> rutina) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.rutina = rutina;
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
		return "TipoRutina [codigo=" + codigo + ", nombre=" + nombre + ", rutina=" + rutina + "]";
	}
	
}
