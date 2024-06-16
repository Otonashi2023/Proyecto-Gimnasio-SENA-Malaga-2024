package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Rutina;
import co.edu.sena.repository.RutinaRepository;

@Service
public class RutinaServiceImpl implements RutinaService {

	@Autowired
	RutinaRepository rutinaRepository;
	
	@Override
	public Optional<Rutina> findById(Integer id) {
		
		return rutinaRepository.findById(id);
	}

	@Override
	public List<Rutina> findAll() {
		
		return rutinaRepository.findAll();
	}

	@Override
	public Rutina save(Rutina r) {
		
		return rutinaRepository.save(r);
	}

	@Override
	public void deleteById(Integer id) {
		
		rutinaRepository.deleteById(id);
	}

}
