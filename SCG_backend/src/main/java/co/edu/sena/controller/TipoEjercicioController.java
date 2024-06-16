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

import co.edu.sena.models.entity.TipoEjercicio;
import co.edu.sena.models.service.TipoEjercicioService;

@RestController
@RequestMapping("/api/tipoejercicio")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TipoEjercicioController {
	@Autowired
	TipoEjercicioService tipoEjercicioService;
	
	@GetMapping("/{id}")
	public Optional<TipoEjercicio> buscarPorId(@PathVariable Integer id) {
		
		return tipoEjercicioService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<TipoEjercicio> listarTodos(){
		
		return tipoEjercicioService.findAll();
	}
	
	@PostMapping
	public TipoEjercicio guardar(@RequestBody TipoEjercicio te) {
		
		return tipoEjercicioService.save(te);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		tipoEjercicioService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public TipoEjercicio actualizar(@RequestBody TipoEjercicio te, @PathVariable Integer id) {
		
		TipoEjercicio teEnBD = tipoEjercicioService.findById(id).get();	
		
		teEnBD.setNombre(te.getNombre());
				
		return tipoEjercicioService.save(teEnBD);
		
	}
}
