package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Cargo;

public interface CargoService {

	public Optional<Cargo>findById(Integer id);
	public List<Cargo> findAll();
	public Cargo save(Cargo c);
	public void deleteById(Integer id);
}
