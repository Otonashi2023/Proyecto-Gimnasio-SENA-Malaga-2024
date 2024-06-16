package co.edu.sena.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.sena.models.entity.AprendizPlan;
import co.edu.sena.models.service.AprendizPlanService;

@RestController
@RequestMapping("/api/aprendizplan")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AprendizPlanController {
	@Autowired
	AprendizPlanService aprendizPlanService;
	
	@GetMapping("/{id}")
	public Optional<AprendizPlan> buscarPorId(@PathVariable BigInteger id) {
		
		return aprendizPlanService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<AprendizPlan> listarTodos(){
		
		return aprendizPlanService.findAll();
	}
	
	@PostMapping
	public AprendizPlan guardar(@RequestBody AprendizPlan ap) {
		
		return aprendizPlanService.save(ap);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		aprendizPlanService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public AprendizPlan actualizar(@RequestBody AprendizPlan ap, @PathVariable BigInteger id) {
		
		AprendizPlan apEnBD = aprendizPlanService.findById(id).get();
		
		apEnBD.setInicio(ap.getInicio());
		apEnBD.setFinaliza(ap.getFinaliza());
		apEnBD.setAprendiz(ap.getAprendiz());
		apEnBD.setPlan(ap.getPlan());
				
		return aprendizPlanService.save(apEnBD);
		
	}
}
