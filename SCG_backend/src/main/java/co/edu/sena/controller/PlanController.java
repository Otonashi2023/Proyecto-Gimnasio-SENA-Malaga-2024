package co.edu.sena.controller;

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

import co.edu.sena.models.entity.Plan;
import co.edu.sena.models.service.PlanService;

@RestController
@RequestMapping("/api/plan")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PlanController {
	@Autowired
	PlanService planService;
	
	@GetMapping("/{id}")
	public Optional<Plan> buscarPorId(@PathVariable Integer id) {
		
		return planService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Plan> listarTodos(){
		
		return planService.findAll();
	}
	
	@PostMapping
	public Plan guardar(@RequestBody Plan p) {
		
		return planService.save(p);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		planService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Plan actualizar(@RequestBody Plan p, @PathVariable Integer id) {
		
		Plan pEnBD = planService.findById(id).get();
		
		pEnBD.setNombre(p.getNombre());
		pEnBD.setMeses(p.getMeses());
				
		return planService.save(pEnBD);
		
	}
}
