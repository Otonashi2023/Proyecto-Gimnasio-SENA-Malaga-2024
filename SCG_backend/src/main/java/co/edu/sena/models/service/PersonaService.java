package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Persona;

public interface PersonaService {

	public Optional<Persona>findById(BigInteger id);
	public List<Persona> findAll();
	public Persona save(Persona pe);
	public void deleteById(BigInteger id);
}
