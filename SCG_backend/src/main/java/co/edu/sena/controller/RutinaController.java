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

import co.edu.sena.models.entity.Rutina;
import co.edu.sena.models.service.RutinaService;

@RestController
@RequestMapping("/api/rutina")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class RutinaController {
	@Autowired
	RutinaService rutinaService;
	
	@GetMapping("/{id}")
	public Optional<Rutina> buscarPorId(@PathVariable Integer id) {
		
		return rutinaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Rutina> listarTodos(){
		
		return rutinaService.findAll();
	}
	
	@PostMapping
	public Rutina guardar(@RequestBody Rutina r) {
		
		return rutinaService.save(r);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		rutinaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Rutina actualizar(@RequestBody Rutina r, @PathVariable Integer id) {
		
		Rutina rEnBD = rutinaService.findById(id).get();	
		
		rEnBD.setNumero(r.getNumero());
		rEnBD.setTipoRutina(r.getTipoRutina());
				
		return rutinaService.save(rEnBD);
		
	}
}
