package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Usuario;

public interface UsuarioService {

	public Usuario save(Usuario u);
	public String login(String user, String ctr);
	public Optional<Usuario>findById(BigInteger id);
	public List<Usuario> findAll();
	public void deleteById(BigInteger id);
}
