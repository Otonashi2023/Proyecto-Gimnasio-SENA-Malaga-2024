package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Perimetros;
import co.edu.sena.repository.PerimetrosRepository;

@Service
public class PerimetrosServiceImpl implements PerimetrosService{

	@Autowired
	PerimetrosRepository perimetrosRepository;
	
	@Override
	public Optional<Perimetros> findById(BigInteger id) {
		
		return perimetrosRepository.findById(id);
	}

	@Override
	public List<Perimetros> findAll() {
		
		return perimetrosRepository.findAll();
	}

	@Override
	public Perimetros save(Perimetros pt) {
		
		return perimetrosRepository.save(pt);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		perimetrosRepository.deleteById(id);
	}

}
