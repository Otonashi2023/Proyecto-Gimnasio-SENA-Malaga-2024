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
@Table(name="plan_rutina")
public class PlanRutina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_plan_rutina", nullable = false)
	private int codigo;
	
	@ManyToOne
	@JoinColumn (name="plan")
	private Plan plan;
	
	@ManyToOne
	@JoinColumn (name="rutina")
	private Rutina rutina;
	
	public PlanRutina() {
		super();
	}

	public PlanRutina(int codigo) {
		super();
		this.codigo = codigo;
	}

	public PlanRutina(Plan plan, Rutina rutina) {
		super();
		this.plan = plan;
		this.rutina = rutina;
	}

	public PlanRutina(int codigo, Plan plan, Rutina rutina) {
		super();
		this.codigo = codigo;
		this.plan = plan;
		this.rutina = rutina;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	@Override
	public String toString() {
		return "PlanRutina [codigo=" + codigo + ", plan=" + plan + ", rutina=" + rutina + "]";
	}
	
}
