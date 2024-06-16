package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Asistencia;
import co.edu.sena.repository.AsistenciaRepository;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{

	@Autowired
	AsistenciaRepository asistenciaRepository;
	
	@Override
	public Optional<Asistencia> findById(BigInteger id) {
		
		return asistenciaRepository.findById(id);
	}

	@Override
	public List<Asistencia> findAll() {
		
		return asistenciaRepository.findAll();
	}

	@Override
	public Asistencia save(Asistencia as) {
		
		return asistenciaRepository.save(as);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		asistenciaRepository.deleteById(id);
	}

}
