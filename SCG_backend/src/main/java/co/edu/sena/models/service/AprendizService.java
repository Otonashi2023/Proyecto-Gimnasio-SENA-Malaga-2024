package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Aprendiz;

public interface AprendizService {

	public Optional<Aprendiz>findById(BigInteger id);
	public List<Aprendiz> findAll();
	public Aprendiz save(Aprendiz a);
	public void deleteById(BigInteger id);
	Aprendiz obtenerAprendizPorId(BigInteger id);
}
