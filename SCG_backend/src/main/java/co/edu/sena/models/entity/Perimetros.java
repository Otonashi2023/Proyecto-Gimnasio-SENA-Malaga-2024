package co.edu.sena.models.entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="perimetros")
public class Perimetros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_perimetros", nullable = false)
	private BigInteger codigo;
	
	@Column (name="cabeza", nullable = false)
	private float cabeza;
	
	@Column (name="cuello", nullable = false)
	private float cuello;
	
	@Column (name="brazo_relax", nullable = false)
	private float brazoRelax;
	
	@Column (name="brazo_tensionado", nullable = false)
	private float brazoTenso;
	
	@Column (name="antebrazo", nullable = false)
	private float antebrazo;
	
	@Column (name="muñeca", nullable = false)
	private float muñeca;
	
	@Column (name="torax", nullable = false)
	private float torax;
	
	@Column (name="cintura", nullable = false)
	private float cintura;
	
	@Column (name="cadera", nullable = false)
	private float cadera;
	
	@Column (name="muslo_max", nullable = false)
	private float musloMax;
	
	@Column (name="muslo_min", nullable = false)
	private float musloMin;
	
	@Column (name="pantorrilla_max", nullable = false)
	private float pantorrillaMax;
	
	@Column (name="pantorrilla_min", nullable = false)
	private float pantorrillaMin;
	
	@OneToOne
	@JoinColumn (name="fichaantropo", nullable = false)
	private FichaAntropo fichaantropo;
	
	public Perimetros() {
		super();
	}

	public Perimetros(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}

	public Perimetros(float cabeza, float cuello, float brazoRelax, float brazoTenso, float antebrazo, float muñeca,
			float torax, float cintura, float cadera, float musloMax, float musloMin, float pantorrillaMax,
			float pantorrillaMin, FichaAntropo fichaantropo) {
		super();
		this.cabeza = cabeza;
		this.cuello = cuello;
		this.brazoRelax = brazoRelax;
		this.brazoTenso = brazoTenso;
		this.antebrazo = antebrazo;
		this.muñeca = muñeca;
		this.torax = torax;
		this.cintura = cintura;
		this.cadera = cadera;
		this.musloMax = musloMax;
		this.musloMin = musloMin;
		this.pantorrillaMax = pantorrillaMax;
		this.pantorrillaMin = pantorrillaMin;
		this.fichaantropo = fichaantropo;
	}

	public Perimetros(BigInteger codigo, float cabeza, float cuello, float brazoRelax, float brazoTenso, float antebrazo,
			float muñeca, float torax, float cintura, float cadera, float musloMax, float musloMin,
			float pantorrillaMax, float pantorrillaMin, FichaAntropo fichaantropo) {
		super();
		this.codigo = codigo;
		this.cabeza = cabeza;
		this.cuello = cuello;
		this.brazoRelax = brazoRelax;
		this.brazoTenso = brazoTenso;
		this.antebrazo = antebrazo;
		this.muñeca = muñeca;
		this.torax = torax;
		this.cintura = cintura;
		this.cadera = cadera;
		this.musloMax = musloMax;
		this.musloMin = musloMin;
		this.pantorrillaMax = pantorrillaMax;
		this.pantorrillaMin = pantorrillaMin;
		this.fichaantropo = fichaantropo;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public float getCabeza() {
		return cabeza;
	}

	public void setCabeza(float cabeza) {
		this.cabeza = cabeza;
	}

	public float getCuello() {
		return cuello;
	}

	public void setCuello(float cuello) {
		this.cuello = cuello;
	}

	public float getBrazoRelax() {
		return brazoRelax;
	}

	public void setBrazoRelax(float brazoRelax) {
		this.brazoRelax = brazoRelax;
	}

	public float getBrazoTenso() {
		return brazoTenso;
	}

	public void setBrazoTenso(float brazoTenso) {
		this.brazoTenso = brazoTenso;
	}

	public float getAntebrazo() {
		return antebrazo;
	}

	public void setAntebrazo(float antebrazo) {
		this.antebrazo = antebrazo;
	}

	public float getMuñeca() {
		return muñeca;
	}

	public void setMuñeca(float muñeca) {
		this.muñeca = muñeca;
	}

	public float getTorax() {
		return torax;
	}

	public void setTorax(float torax) {
		this.torax = torax;
	}

	public float getCintura() {
		return cintura;
	}

	public void setCintura(float cintura) {
		this.cintura = cintura;
	}

	public float getCadera() {
		return cadera;
	}

	public void setCadera(float cadera) {
		this.cadera = cadera;
	}

	public float getMusloMax() {
		return musloMax;
	}

	public void setMusloMax(float musloMax) {
		this.musloMax = musloMax;
	}

	public float getMusloMin() {
		return musloMin;
	}

	public void setMusloMin(float musloMin) {
		this.musloMin = musloMin;
	}

	public float getPantorrillaMax() {
		return pantorrillaMax;
	}

	public void setPantorrillaMax(float pantorrillaMax) {
		this.pantorrillaMax = pantorrillaMax;
	}

	public float getPantorrillaMin() {
		return pantorrillaMin;
	}

	public void setPantorrillaMin(float pantorrillaMin) {
		this.pantorrillaMin = pantorrillaMin;
	}
	
	public FichaAntropo getFichaantropo() {
		return fichaantropo;
	}

	public void setFichaantropo(FichaAntropo fichaantropo) {
		this.fichaantropo = fichaantropo;
	}

	@Override
	public String toString() {
		return "Perimetros [codigo=" + codigo + ", cabeza=" + cabeza + ", cuello=" + cuello + ", brazoRelax="
				+ brazoRelax + ", brazoTenso=" + brazoTenso + ", antebrazo=" + antebrazo + ", muñeca=" + muñeca
				+ ", torax=" + torax + ", cintura=" + cintura + ", cadera=" + cadera + ", musloMax=" + musloMax
				+ ", musloMin=" + musloMin + ", pantorrillaMax=" + pantorrillaMax + ", pantorrillaMin=" + pantorrillaMin
				+ ", fichaantropo=" + fichaantropo + "]";
	}
	
}
