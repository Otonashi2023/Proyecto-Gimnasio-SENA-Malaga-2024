package co.edu.sena.models.entity;

import java.math.BigInteger;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aprendiz_plan")
public class AprendizPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_aprendiz_plan", nullable = false)
	private BigInteger codigo;
	
	@Column (name="inicio", nullable = false)
	private LocalDate inicio;
	
	@Column (name="finaliza", nullable = false)
	private LocalDate finaliza;
	
	@ManyToOne
	@JoinColumn (name="aprendiz")
	private Aprendiz aprendiz;
	
	@ManyToOne
	@JoinColumn (name="plan")
	private Plan plan;
	
	public AprendizPlan() {
		super();
	}

	public AprendizPlan(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}
	
	public AprendizPlan(LocalDate inicio, LocalDate finaliza, Aprendiz aprendiz, Plan plan) {
		super();
		this.inicio = inicio;
		this.finaliza = finaliza;
		this.aprendiz = aprendiz;
		this.plan = plan;
	}
	
	public AprendizPlan(BigInteger codigo, LocalDate inicio, LocalDate finaliza, Aprendiz aprendiz, Plan plan) {
		super();
		this.codigo = codigo;
		this.inicio = inicio;
		this.finaliza = finaliza;
		this.aprendiz = aprendiz;
		this.plan = plan;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFinaliza() {
		return finaliza;
	}

	public void setFinaliza(LocalDate finaliza) {
		this.finaliza = finaliza;
	}
	
	public Aprendiz getAprendiz() {
		return aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "AprendizPlan [codigo=" + codigo + ", inicio=" + inicio + ", finaliza=" + finaliza + ", aprendiz="
				+ aprendiz + ", plan=" + plan + "]";
	}
	
}
