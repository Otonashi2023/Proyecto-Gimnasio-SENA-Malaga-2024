package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import co.edu.sena.models.entity.AprendizPlan;

public interface AprendizPlanService {

	public Optional<AprendizPlan>findById(BigInteger id);
	public List<AprendizPlan> findAll();
	public AprendizPlan save(AprendizPlan ap);
	public void deleteById(BigInteger id);
}
