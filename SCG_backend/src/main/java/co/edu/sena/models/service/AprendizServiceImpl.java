package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Aprendiz;
import co.edu.sena.repository.AprendizRepository;

@Service
public class AprendizServiceImpl implements AprendizService{

	@Autowired
	AprendizRepository aprendizRepository;
	
	@Override
	public Optional<Aprendiz> findById(BigInteger id) {
		
		return aprendizRepository.findById(id);
	}

	@Override
	public List<Aprendiz> findAll() {
		
		return aprendizRepository.findAll();
	}

	@Override
	public Aprendiz save(Aprendiz a) {
		
		return aprendizRepository.save(a);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		aprendizRepository.deleteById(id);
	}

	@Override
	public Aprendiz obtenerAprendizPorId(BigInteger id) {
		
		return aprendizRepository.findById(id).orElse(null);
	}

}
