package co.edu.sena.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.sena.models.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger>{

	Usuario findByUsername(String user);
}
