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
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_usu", nullable = false)
	private BigInteger codigo;
	
	@Column (name="nom_usu", length = 45, nullable = false)
	private String username;
	
	@Column (name="cont_usu", length = 45, nullable = false)
	private String password;
		
	@OneToOne
	@JoinColumn (name="personal")
	private Personal personal;
	
	public Usuario() {
		super();
	}

	public Usuario(BigInteger codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Usuario(String username, String password, Personal personal) {
		super();
		this.username = username;
		this.password = password;
		this.personal = personal;
	}
	
	public Usuario(BigInteger codigo, String username, String password, Personal personal) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.password = password;
		this.personal = personal;
	}

	public BigInteger getCodigo() {
		return codigo;
	}

	public void setCodigo(BigInteger codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", username=" + username + ", password=" + password + ", personal="
				+ personal + "]";
	}
	
}
