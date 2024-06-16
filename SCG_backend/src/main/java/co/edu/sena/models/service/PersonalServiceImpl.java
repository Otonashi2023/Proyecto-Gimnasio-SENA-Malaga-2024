package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Personal;
import co.edu.sena.repository.PersonalRepository;

@Service
public class PersonalServiceImpl implements PersonalService{

	@Autowired
	PersonalRepository personalRepository;
	
	@Override
	public Optional<Personal> findById(BigInteger id) {
		
		return personalRepository.findById(id);
	}

	@Override
	public List<Personal> findAll() {
		
		return personalRepository.findAll();
	}

	@Override
	public Personal save(Personal pl) {
		
		return personalRepository.save(pl);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		personalRepository.deleteById(id);
	}

}
