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

import co.edu.sena.models.entity.RutinaEjercicio;
import co.edu.sena.models.service.RutinaEjercicioService;

@RestController
@RequestMapping("/api/rutinaejercicio")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RutinaEjercicioController {
	@Autowired
	RutinaEjercicioService rutinaEjercicioService;
	
	@GetMapping("/{id}")
	public Optional<RutinaEjercicio> buscarPorId(@PathVariable Integer id) {
		
		return rutinaEjercicioService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<RutinaEjercicio> listarTodos(){
		
		return rutinaEjercicioService.findAll();
	}
	
	@PostMapping
	public RutinaEjercicio guardar(@RequestBody RutinaEjercicio re) {
		
		return rutinaEjercicioService.save(re);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		rutinaEjercicioService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public RutinaEjercicio actualizar(@RequestBody RutinaEjercicio re, @PathVariable Integer id) {
		
		RutinaEjercicio reEnBD = rutinaEjercicioService.findById(id).get();
		
		reEnBD.setRutina(re.getRutina());
		reEnBD.setEjercicio(re.getEjercicio());
				
		return rutinaEjercicioService.save(reEnBD);
		
	}
}
