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

import co.edu.sena.models.entity.TipoRutina;
import co.edu.sena.models.service.TipoRutinaService;

@RestController
@RequestMapping("/api/tiporutina")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TipoRutinaController {
	@Autowired
	TipoRutinaService tipoRutinaService;
	
	@GetMapping("/{id}")
	public Optional<TipoRutina> buscarPorId(@PathVariable Integer id) {
		
		return tipoRutinaService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<TipoRutina> listarTodos(){
		
		return tipoRutinaService.findAll();
	}
	
	@PostMapping
	public TipoRutina guardar(@RequestBody TipoRutina tr) {
		
		return tipoRutinaService.save(tr);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		tipoRutinaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public TipoRutina actualizar(@RequestBody TipoRutina tr, @PathVariable Integer id) {
		
		TipoRutina trEnBD = tipoRutinaService.findById(id).get();
		
		trEnBD.setNombre(tr.getNombre());
				
		return tipoRutinaService.save(trEnBD);
		
	}
}
