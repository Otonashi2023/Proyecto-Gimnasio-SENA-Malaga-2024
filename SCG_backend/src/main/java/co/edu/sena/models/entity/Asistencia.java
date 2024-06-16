package co.edu.sena.models.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="asistencia")
public class Asistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_asist", nullable = false)
	private BigInteger codigo;
	
	@Column (name="fecha", nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn (name="aprendiz")
	private Aprendiz aprendiz;

	public Asistencia() {
		super();
	}

	public Asistencia(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}

	public Asistencia(LocalDateTime fecha, Aprendiz aprendiz) {
		super();
		this.fecha = fecha;
		this.aprendiz = aprendiz;
	}

	public Asistencia(BigInteger codigo, LocalDateTime fecha, Aprendiz aprendiz) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.aprendiz = aprendiz;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Aprendiz getAprendiz() {
		return aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	@Override
	public String toString() {
		return "Asistencia [codigo=" + codigo + ", fecha=" + fecha + ", aprendiz=" + aprendiz + "]";
	}
	@PrePersist
    protected void onCreate() {
        fecha = LocalDateTime.now();
	}
}
