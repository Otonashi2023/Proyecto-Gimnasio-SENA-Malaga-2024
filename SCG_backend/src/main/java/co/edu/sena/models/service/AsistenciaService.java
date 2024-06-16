package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Asistencia;

public interface AsistenciaService {

	public Optional<Asistencia>findById(BigInteger id);
	public List<Asistencia> findAll();
	public Asistencia save(Asistencia as);
	public void deleteById(BigInteger id);
}
