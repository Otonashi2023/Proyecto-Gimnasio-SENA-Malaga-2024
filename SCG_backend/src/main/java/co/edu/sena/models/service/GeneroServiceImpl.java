package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Genero;
import co.edu.sena.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	GeneroRepository generoRepository;
	
	@Override
	public Optional<Genero> findById(Integer id) {
		
		return generoRepository.findById(id);
	}

	@Override
	public List<Genero> findAll() {
		
		return generoRepository.findAll();
	}

	@Override
	public Genero save(Genero g) {
		
		return generoRepository.save(g);
	}

	@Override
	public void deleteById(Integer id) {
		
		generoRepository.deleteById(id);
	}

}
