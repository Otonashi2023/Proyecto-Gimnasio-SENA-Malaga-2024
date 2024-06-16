package co.edu.sena.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="rutina_ejercicio")
public class RutinaEjercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_rutina_ejercicio", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn (name="rutina")
	private Rutina rutina;
	
	@ManyToOne
	@JoinColumn (name="ejercicio")
	private Ejercicio ejercicio;
	
	public RutinaEjercicio() {
		super();
	}

	public RutinaEjercicio(int codigo) {
		super();
		this.codigo = codigo;
	}

	public RutinaEjercicio(Rutina rutina, Ejercicio ejercicio) {
		super();
		this.rutina = rutina;
		this.ejercicio = ejercicio;
	}

	public RutinaEjercicio(int codigo, Rutina rutina, Ejercicio ejercicio) {
		super();
		this.codigo = codigo;
		this.rutina = rutina;
		this.ejercicio = ejercicio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public String toString() {
		return "RutinaEjercicio [codigo=" + codigo + ", rutina=" + rutina + ", ejercicio=" + ejercicio + "]";
	}
	
}
