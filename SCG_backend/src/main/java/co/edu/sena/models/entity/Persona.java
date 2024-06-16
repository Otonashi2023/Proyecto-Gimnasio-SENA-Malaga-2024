package co.edu.sena.models.entity;

import java.math.BigInteger;

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
@Table(name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_person", nullable = false)
	private BigInteger codigo;
	
	@Column (name="nombres", length = 45, nullable = false)
	private String nombres;
	
	@Column (name="apellidos", length = 45, nullable = false)
	private String apellidos;
	
	@Column (name="cedula", nullable = false)
	private BigInteger cedula;
	
	@Column (name="celular", nullable = false)
	private BigInteger celular;
	
	@Column (name="nom_contacto", length = 45, nullable = false)
	private String contacto;
	
	@Column (name="celular_alt", nullable = false)
	private BigInteger celularAlt;
	
	@Column (name="email", length = 45, nullable = false)
	private String correo;
	
	@ManyToOne
	@JoinColumn (name="tipo_documento")
	private TipoDocumento tipoDocumento;
	
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL) //relacion 1 a 1
	private Aprendiz aprendiz;
	
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL) //relacion 1 a 1
	private Personal personal;

	public Persona() {
		super();
	}

	public Persona(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}

	public Persona(String nombres, String apellidos, BigInteger cedula, BigInteger celular, String contacto,
			BigInteger celularAlt, String correo, TipoDocumento tipoDocumento, Aprendiz aprendiz, Personal personal) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.celular = celular;
		this.contacto = contacto;
		this.celularAlt = celularAlt;
		this.correo = correo;
		this.tipoDocumento = tipoDocumento;
		this.aprendiz = aprendiz;
		this.personal = personal;
	}
	
	public Persona(BigInteger codigo, String nombres, String apellidos, BigInteger cedula, BigInteger celular, String contacto,
			BigInteger celularAlt, String correo, TipoDocumento tipoDocumento, Aprendiz aprendiz, Personal personal) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.celular = celular;
		this.contacto = contacto;
		this.celularAlt = celularAlt;
		this.correo = correo;
		this.tipoDocumento = tipoDocumento;
		this.aprendiz = aprendiz;
		this.personal = personal;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigInteger getCedula() {
		return cedula;
	}

	public void setCedula(BigInteger cedula) {
		this.cedula = cedula;
	}
	
	public BigInteger getCelular() {
		return celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public BigInteger getCelularAlt() {
		return celularAlt;
	}

	public void setCelularAlt(BigInteger cedularAlt) {
		this.celularAlt = cedularAlt;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula
				+ ", celular=" + celular + ", contacto=" + contacto + ", celularAlt=" + celularAlt + ", correo="
				+ correo + ", tipoDocumento=" + tipoDocumento + ", aprendiz=" + aprendiz + ", personal=" + personal
				+ "]";
	}
	
}
