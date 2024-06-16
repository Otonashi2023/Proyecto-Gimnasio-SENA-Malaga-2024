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

import co.edu.sena.models.entity.Ejercicio;
import co.edu.sena.models.service.EjercicioService;

@RestController
@RequestMapping("/api/ejercicio")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class EjercicioController {
	@Autowired
	EjercicioService ejercicioService;
	
	@GetMapping("/{id}")
	public Optional<Ejercicio> buscarPorId(@PathVariable Integer id) {
		
		return ejercicioService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<Ejercicio> listarTodos(){
		
		return ejercicioService.findAll();
	}
	
	@PostMapping
	public Ejercicio guardar(@RequestBody Ejercicio e) {
		
		return ejercicioService.save(e);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		ejercicioService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Ejercicio actualizar(@RequestBody Ejercicio e, @PathVariable Integer id) {
		
		Ejercicio eEnBD = ejercicioService.findById(id).get();
		
		eEnBD.setNombre(e.getNombre());
		eEnBD.setSeries(e.getSeries());
		eEnBD.setRepeticiones(e.getRepeticiones());
		eEnBD.setDescanso(e.getDescanso());
		eEnBD.setTipoEjercicio(e.getTipoEjercicio());
		eEnBD.setMusculo(e.getMusculo());
		
		return ejercicioService.save(eEnBD);
		
	}
}
