package co.edu.sena.models.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.AprendizPlan;
import co.edu.sena.repository.AprendizPlanRepository;

@Service
public class AprendizPlanServiceImpl implements AprendizPlanService{

	@Autowired
	AprendizPlanRepository aprendizPlanRepository;
	
	@Override
	public Optional<AprendizPlan> findById(BigInteger id) {
		
		return aprendizPlanRepository.findById(id);
	}

	@Override
	public List<AprendizPlan> findAll() {
		
		return aprendizPlanRepository.findAll();
	}

	@Override
	public AprendizPlan save(AprendizPlan ap) {
		
		return aprendizPlanRepository.save(ap);
	}

	@Override
	public void deleteById(BigInteger id) {
		
		aprendizPlanRepository.deleteById(id);
	}

}
