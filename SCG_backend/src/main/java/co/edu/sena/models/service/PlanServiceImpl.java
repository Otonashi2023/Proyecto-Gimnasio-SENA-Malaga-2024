package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.Plan;
import co.edu.sena.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanRepository planRepository;
	
	@Override
	public Optional<Plan> findById(Integer id) {
		
		return planRepository.findById(id);
	}

	@Override
	public List<Plan> findAll() {
		
		return planRepository.findAll();
	}

	@Override
	public Plan save(Plan p) {
		
		return planRepository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		
		planRepository.deleteById(id);
	}

	
}
