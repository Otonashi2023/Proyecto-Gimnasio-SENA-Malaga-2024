package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.PlanRutina;

public interface PlanRutinaService {

	public Optional<PlanRutina>findById(Integer id);
	public List<PlanRutina> findAll();
	public PlanRutina save(PlanRutina pr);
	public void deleteById(Integer id);
}
