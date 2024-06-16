package co.edu.sena.models.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name="personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_personal", nullable = false)
	private BigInteger codigo;
	
	@OneToOne
	@JoinColumn (name="persona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn (name="cargo")
	private Cargo cargo;
	
	@OneToOne(mappedBy = "personal", cascade = CascadeType.ALL) //relacion 1 a 1
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "personal")
	private List<FichaAntropo> fichaantropo = new ArrayList<>();

	public Personal() {
		super();
	}

	public Personal(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Personal(Persona persona, Cargo cargo, Usuario usuario, List<FichaAntropo> fichaantropo) {
		super();
		this.persona = persona;
		this.cargo = cargo;
		this.usuario = usuario;
		this.fichaantropo = fichaantropo;
	}
	
	public Personal(BigInteger codigo, Persona persona, Cargo cargo, Usuario usuario, List<FichaAntropo> fichaantropo) {
		super();
		this.codigo = codigo;
		this.persona = persona;
		this.cargo = cargo;
		this.usuario = usuario;
		this.fichaantropo = fichaantropo;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Personal [codigo=" + codigo + ", persona=" + persona + ", cargo=" + cargo + ", usuario=" + usuario
				+ ", fichaantropo=" + fichaantropo + "]";
	}
	
}
