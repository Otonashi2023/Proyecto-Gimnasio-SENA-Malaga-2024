package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.Plan;

public interface PlanService {

	public Optional<Plan>findById(Integer id);
	public List<Plan> findAll();
	public Plan save(Plan p);
	public void deleteById(Integer id);
}
