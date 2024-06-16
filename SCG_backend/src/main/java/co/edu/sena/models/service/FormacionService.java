package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Formacion;

public interface FormacionService {

	public Optional<Formacion>findById(Integer id);
	public List<Formacion> findAll();
	public Formacion save(Formacion fo);
	public void deleteById(Integer id);
}
