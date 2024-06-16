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
@Table(name="plan")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_plan", nullable = false)
	private int codigo;
	
	@Column (name="nom_plan", length = 45, nullable = false)
	private String nombre;
	
	@Column (name="meses", nullable = false)
	private int meses;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "plan")
	private List<AprendizPlan> aprendizPlan = new ArrayList<>();
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "plan")
	private List<PlanRutina> planRutina = new ArrayList<>();
	
	public Plan() {
		super();
	}

	public Plan(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Plan(String nombre, int meses, List<AprendizPlan> aprendizPlan, List<PlanRutina> planRutina) {
		super();
		this.nombre = nombre;
		this.meses = meses;
		this.aprendizPlan = aprendizPlan;
		this.planRutina = planRutina;
	}

	public Plan(int codigo, String nombre, int meses, List<AprendizPlan> aprendizPlan, List<PlanRutina> planRutina) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.meses = meses;
		this.aprendizPlan = aprendizPlan;
		this.planRutina = planRutina;
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

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	@Override
	public String toString() {
		return "Plan [codigo=" + codigo + ", nombre=" + nombre + ", meses=" + meses + ", aprendizPlan=" + aprendizPlan
				+ ", planRutina=" + planRutina + "]";
	}
	
}
