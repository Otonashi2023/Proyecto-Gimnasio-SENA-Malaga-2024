package co.edu.sena.models.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="fichaantropo")
public class FichaAntropo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_fich_ant", nullable = false)
	private BigInteger codigo;
	
	@Column (name="num_control", nullable = false)
	private int numControl;
	
	@Column (name="fecha_toma", nullable = false)
	private LocalDate fecha;
	
	@Column (name="altura", nullable = false)
	private float altura;
	
	@Column (name="peso", nullable = false)
	private float peso;
	
	@Column (name="imc", nullable = false)
	private float imc;
	
	@ManyToOne
	@JoinColumn (name="personal")
	private Personal personal;
	
	@ManyToOne
	@JoinColumn (name="genero")
	private Genero genero;
	
	@ManyToOne
	@JoinColumn (name="aprendiz")
	private Aprendiz aprendiz;

	@OneToOne(mappedBy = "fichaantropo", cascade = CascadeType.ALL) //relacion 1 a 1
	private Perimetros perimetros;

	public FichaAntropo() {
		super();
	}

	public FichaAntropo(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}
	
	public FichaAntropo(int numControl, LocalDate fecha, float altura, float peso, float imc, Personal personal,
			Genero genero, Aprendiz aprendiz, Perimetros perimetros) {
		super();
		this.numControl = numControl;
		this.fecha = fecha;
		this.altura = altura;
		this.peso = peso;
		this.imc = imc;
		this.personal = personal;
		this.genero = genero;
		this.aprendiz = aprendiz;
		this.perimetros = perimetros;
	}
	
	public FichaAntropo(BigInteger codigo, int numControl, LocalDate fecha, float altura, float peso, float imc,
			Personal personal, Genero genero, Aprendiz aprendiz, Perimetros perimetros) {
		super();
		this.codigo = codigo;
		this.numControl = numControl;
		this.fecha = fecha;
		this.altura = altura;
		this.peso = peso;
		this.imc = imc;
		this.personal = personal;
		this.genero = genero;
		this.aprendiz = aprendiz;
		this.perimetros = perimetros;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public int getNumControl() {
		return numControl;
	}

	public void setNumControl(int numControl) {
		this.numControl = numControl;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Aprendiz getAprendiz() {
		return aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	@Override
	public String toString() {
		return "FichaAntropo [codigo=" + codigo + ", numControl=" + numControl + ", fecha=" + fecha + ", altura="
				+ altura + ", peso=" + peso + ", imc=" + imc + ", personal=" + personal + ", genero=" + genero
				+ ", aprendiz=" + aprendiz + ", perimetros=" + perimetros + "]";
	}
	
}