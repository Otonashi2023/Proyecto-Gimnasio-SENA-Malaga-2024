package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Cargo;
import co.edu.sena.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService{

	@Autowired
	CargoRepository cargoRepository;
	
	@Override
	public Optional<Cargo> findById(Integer id) {
		
		return cargoRepository.findById(id);
	}

	@Override
	public List<Cargo> findAll() {
		
		return cargoRepository.findAll();
	}

	@Override
	public Cargo save(Cargo c) {
		
		return cargoRepository.save(c);
	}

	@Override
	public void deleteById(Integer id) {
		
		cargoRepository.deleteById(id);
	}

}
