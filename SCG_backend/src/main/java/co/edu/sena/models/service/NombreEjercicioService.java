package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.NombreEjercicio;

public interface NombreEjercicioService {

	public Optional<NombreEjercicio>findById(Integer id);
	public List<NombreEjercicio> findAll();
	public NombreEjercicio save(NombreEjercicio ne);
	public void deleteById(Integer id);
}
