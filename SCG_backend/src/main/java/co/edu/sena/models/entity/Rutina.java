package co.edu.sena.models.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rutina")
public class Rutina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_rutina", nullable = false)
	private int codigo;
	
	@Column (name="numero_rutina", nullable = false)
	private int numero;
	
	@ManyToOne
	@JoinColumn (name="tipo_rutina")
	private TipoRutina tipoRutina;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "rutina")
	private List<PlanRutina> planRutina = new ArrayList<>();
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "rutina")
	private List<RutinaEjercicio> rutinaEjercicio = new ArrayList<>();
	
	public Rutina() {
		super();
	}

	public Rutina(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Rutina(int numero, TipoRutina tipoRutina, List<PlanRutina> planRutina,
			List<RutinaEjercicio> rutinaEjercicio) {
		super();
		this.numero = numero;
		this.tipoRutina = tipoRutina;
		this.planRutina = planRutina;
		this.rutinaEjercicio = rutinaEjercicio;
	}
	
	public Rutina(int codigo, int numero, TipoRutina tipoRutina, List<PlanRutina> planRutina,
			List<RutinaEjercicio> rutinaEjercicio) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.tipoRutina = tipoRutina;
		this.planRutina = planRutina;
		this.rutinaEjercicio = rutinaEjercicio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TipoRutina getTipoRutina() {
		return tipoRutina;
	}

	public void setTipoRutina(TipoRutina tipoRutina) {
		this.tipoRutina = tipoRutina;
	}

	@Override
	public String toString() {
		return "Rutina [codigo=" + codigo + ", numero=" + numero + ", tipoRutina=" + tipoRutina + ", planRutina="
				+ planRutina + ", rutinaEjercicio=" + rutinaEjercicio + "]";
	}
		
}
