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
import jakarta.persistence.Table;

@Entity
@Table(name="ficha")
public class Ficha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_ficha", nullable = false)
	private int codigo;
	
	@Column (name="numero", nullable = false)
	private BigInteger numero;
	
	@ManyToOne
	@JoinColumn (name="formacion")
	private Formacion formacion;
	
	@OneToMany
	@JoinColumn(name = "ficha")
	private List<Aprendiz> aprendiz = new ArrayList<>();

	public Ficha() {
		super();
	}

	public Ficha(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Ficha(BigInteger numero, Formacion formacion, List<Aprendiz> aprendiz) {
		super();
		this.numero = numero;
		this.formacion = formacion;
		this.aprendiz = aprendiz;
	}

	public Ficha(int codigo, BigInteger numero, Formacion formacion, List<Aprendiz> aprendiz) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.formacion = formacion;
		this.aprendiz = aprendiz;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public BigInteger getNumero() {
		return numero;
	}

	public void setNumero(BigInteger numero) {
		this.numero = numero;
	}

	public Formacion getFormacion() {
		return formacion;
	}

	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}

	@Override
	public String toString() {
		return "Ficha [codigo=" + codigo + ", numero=" + numero + ", formacion=" + formacion + ", aprendiz=" + aprendiz
				+ "]";
	}
	
}
