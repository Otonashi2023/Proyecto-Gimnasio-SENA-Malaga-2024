package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Ejercicio;
import co.edu.sena.repository.EjercicioRepository;

@Service
public class EjercicioServiceImpl implements EjercicioService {

	@Autowired
	EjercicioRepository ejercicioRepository;
	
	@Override
	public Optional<Ejercicio> findById(Integer id) {
		
		return ejercicioRepository.findById(id);
	}

	@Override
	public List<Ejercicio> findAll() {
		
		return ejercicioRepository.findAll();
	}

	@Override
	public Ejercicio save(Ejercicio e) {
		
		return ejercicioRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		
		ejercicioRepository.deleteById(id);
	}

}
