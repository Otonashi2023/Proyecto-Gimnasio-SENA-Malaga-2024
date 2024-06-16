package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Ejercicio;

public interface EjercicioService {

	public Optional<Ejercicio>findById(Integer id);
	public List<Ejercicio> findAll();
	public Ejercicio save(Ejercicio e);
	public void deleteById(Integer id);
}
