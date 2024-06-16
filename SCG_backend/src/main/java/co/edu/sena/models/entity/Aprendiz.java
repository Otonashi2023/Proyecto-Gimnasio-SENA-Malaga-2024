package co.edu.sena.models.entity;

import java.math.BigInteger;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aprendiz")
public class Aprendiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_aprend", nullable = false)
	private BigInteger codigo;
	
	@Column (name="restric_medicas", length = 200, nullable = false)
	private String restricMedicas;
	
	@OneToOne
	@JoinColumn (name="persona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn (name="ficha")
	private Ficha ficha;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "aprendiz")
	private List<Asistencia> asistencia = new ArrayList<>();
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "aprendiz")
	private List<AprendizPlan> aprendizPlan = new ArrayList<>();

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "aprendiz")
	private List<FichaAntropo> fichaantropo = new ArrayList<>();
	
	public Aprendiz() {
		super();
	}

	public Aprendiz(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}

	public Aprendiz(String restricMedicas, Persona persona, Ficha ficha, List<Asistencia> asistencia,
			List<AprendizPlan> aprendizPlan, List<FichaAntropo> fichaantropo) {
		super();
		this.restricMedicas = restricMedicas;
		this.persona = persona;
		this.ficha = ficha;
		this.asistencia = asistencia;
		this.aprendizPlan = aprendizPlan;
		this.fichaantropo = fichaantropo;
	}
	
	public Aprendiz(BigInteger codigo, String restricMedicas, Persona persona, Ficha ficha, List<Asistencia> asistencia,
			List<AprendizPlan> aprendizPlan, List<FichaAntropo> fichaantropo) {
		super();
		this.codigo = codigo;
		this.restricMedicas = restricMedicas;
		this.persona = persona;
		this.ficha = ficha;
		this.asistencia = asistencia;
		this.aprendizPlan = aprendizPlan;
		this.fichaantropo = fichaantropo;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getRestricMedicas() {
		return restricMedicas;
	}

	public void setRestricMedicas(String restricMedicas) {
		this.restricMedicas = restricMedicas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	@Override
	public String toString() {
		return "Aprendiz [codigo=" + codigo + ", restricMedicas=" + restricMedicas + ", persona=" + persona + ", ficha="
				+ ficha + ", asistencia=" + asistencia + ", aprendizPlan=" + aprendizPlan + ", fichaantropo="
				+ fichaantropo + "]";
	}
	
}
