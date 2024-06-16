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

import co.edu.sena.models.entity.PlanRutina;
import co.edu.sena.models.service.PlanRutinaService;

@RestController
@RequestMapping("/api/planrutina")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PlanRutinaController {
	@Autowired
	PlanRutinaService planRutinaService;
	
	@GetMapping("/{id}")
	public Optional<PlanRutina> buscarPorId(@PathVariable Integer id) {
		
		return planRutinaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<PlanRutina> listarTodos(){
		
		return planRutinaService.findAll();
	}
	
	@PostMapping
	public PlanRutina guardar(@RequestBody PlanRutina pr) {
		
		return planRutinaService.save(pr);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		planRutinaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public PlanRutina actualizar(@RequestBody PlanRutina pr, @PathVariable Integer id) {
		
		PlanRutina prEnBD = planRutinaService.findById(id).get();
		
		prEnBD.setPlan(pr.getPlan());
		prEnBD.setRutina(pr.getRutina());
				
		return planRutinaService.save(prEnBD);
		
	}
}
