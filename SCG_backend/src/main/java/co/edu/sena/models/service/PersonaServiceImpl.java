package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Persona;
import co.edu.sena.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public Optional<Persona> findById(BigInteger id) {
		
		return personaRepository.findById(id);
	}

	@Override
	public List<Persona> findAll() {
		
		return personaRepository.findAll();
	}

	@Override
	public Persona save(Persona pe) {
		
		return personaRepository.save(pe);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		personaRepository.deleteById(id);
	}

}
