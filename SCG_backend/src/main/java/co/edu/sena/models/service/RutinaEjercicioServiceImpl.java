package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.RutinaEjercicio;
import co.edu.sena.repository.RutinaEjercicioRepository;

@Service
public class RutinaEjercicioServiceImpl implements RutinaEjercicioService {

	@Autowired
	RutinaEjercicioRepository rutinaEjercicioRepository;
	
	@Override
	public Optional<RutinaEjercicio> findById(Integer id) {
		
		return rutinaEjercicioRepository.findById(id);
	}

	@Override
	public List<RutinaEjercicio> findAll() {
		
		return rutinaEjercicioRepository.findAll();
	}

	@Override
	public RutinaEjercicio save(RutinaEjercicio re) {
		
		return rutinaEjercicioRepository.save(re);
	}

	@Override
	public void deleteById(Integer id) {
		
		rutinaEjercicioRepository.deleteById(id);
	}

}
