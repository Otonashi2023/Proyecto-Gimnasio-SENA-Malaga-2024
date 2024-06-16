package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Ficha;
import co.edu.sena.repository.FichaRepository;

@Service
public class FichaServiceImpl implements FichaService{

	@Autowired
	FichaRepository fichaRepository;
	
	@Override
	public Optional<Ficha> findById(Integer id) {
		
		return fichaRepository.findById(id);
	}

	@Override
	public List<Ficha> findAll() {
		
		return fichaRepository.findAll();
	}

	@Override
	public Ficha save(Ficha fi) {
		
		return fichaRepository.save(fi);
	}

	@Override
	public void deleteById(Integer id) {
		
		fichaRepository.deleteById(id);
	}

}
