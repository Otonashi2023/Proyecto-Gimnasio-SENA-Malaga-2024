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

import co.edu.sena.models.entity.NombreEjercicio;
import co.edu.sena.models.service.NombreEjercicioService;

@RestController
@RequestMapping("/api/nombreejercicio")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class NombreEjercicioController {
	@Autowired
	NombreEjercicioService nombreEjercicioService;
	
	@GetMapping("/{id}")
	public Optional<NombreEjercicio> buscarPorId(@PathVariable Integer id) {
		
		return nombreEjercicioService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<NombreEjercicio> listarTodos(){
		
		return nombreEjercicioService.findAll();
	}
	
	@PostMapping
	public NombreEjercicio guardar(@RequestBody NombreEjercicio ne) {
		
		return nombreEjercicioService.save(ne);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		nombreEjercicioService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public NombreEjercicio actualizar(@RequestBody NombreEjercicio ne, @PathVariable Integer id) {
		
		NombreEjercicio neEnBD = nombreEjercicioService.findById(id).get();
		
		neEnBD.setNombre(ne.getNombre());
		
		return nombreEjercicioService.save(neEnBD);
		
	}
}
