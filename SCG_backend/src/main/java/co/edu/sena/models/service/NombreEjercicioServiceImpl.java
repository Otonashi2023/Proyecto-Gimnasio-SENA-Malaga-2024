package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.NombreEjercicio;
import co.edu.sena.repository.NombreEjercicioRepository;

@Service
public class NombreEjercicioServiceImpl implements NombreEjercicioService {

	@Autowired
	NombreEjercicioRepository nombreEjercicioRepository;
	
	@Override
	public Optional<NombreEjercicio> findById(Integer id) {
		
		return nombreEjercicioRepository.findById(id);
	}

	@Override
	public List<NombreEjercicio> findAll() {
		
		return nombreEjercicioRepository.findAll();
	}

	@Override
	public NombreEjercicio save(NombreEjercicio ne) {
		
		return nombreEjercicioRepository.save(ne);
	}

	@Override
	public void deleteById(Integer id) {
		
		nombreEjercicioRepository.deleteById(id);
	}

}
