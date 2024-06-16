package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Musculo;
import co.edu.sena.repository.MusculoRepository;

@Service
public class MusculoServiceImpl implements MusculoService{

	@Autowired
	MusculoRepository musculoRepository;
	
	@Override
	public Optional<Musculo> findById(Integer id) {
		
		return musculoRepository.findById(id);
	}

	@Override
	public List<Musculo> findAll() {
		
		return musculoRepository.findAll();
	}

	@Override
	public Musculo save(Musculo m) {
		
		return musculoRepository.save(m);
	}

	@Override
	public void deleteById(Integer id) {
		
		musculoRepository.deleteById(id);
	}

}
