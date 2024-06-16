package co.edu.sena.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sena.models.entity.PlanRutina;
import co.edu.sena.repository.PlanRutinaRepository;

@Service
public class PlanRutinaServiceImpl implements PlanRutinaService{

	@Autowired
	PlanRutinaRepository planRutinaRepository;
	
	@Override
	public Optional<PlanRutina> findById(Integer id) {
		
		return planRutinaRepository.findById(id);
	}

	@Override
	public List<PlanRutina> findAll() {
		
		return planRutinaRepository.findAll();
	}

	@Override
	public PlanRutina save(PlanRutina pr) {
		
		return planRutinaRepository.save(pr);
	}

	@Override
	public void deleteById(Integer id) {
		
		planRutinaRepository.deleteById(id);
	}

}
