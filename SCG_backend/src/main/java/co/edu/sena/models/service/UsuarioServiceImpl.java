package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Usuario;
import co.edu.sena.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario save(Usuario u) {
		
		return usuarioRepository.save(u);
	}

	@Override
	public String login(String user, String ctr) {
		
		Usuario usuario = usuarioRepository.findByUsername(user);
		
		if(usuario == null) {
			return "usuario no encontrado";
		}
		
		if(!usuario.getPassword().equals(ctr)) {
			return "contraseña incorrecta";
		}
		
		return "inicio de sesion exitoso";
	}

	@Override
	public Optional<Usuario> findById(BigInteger id) {
		
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	public void deleteById(BigInteger id) {
		
		usuarioRepository.deleteById(id);
	}

}
