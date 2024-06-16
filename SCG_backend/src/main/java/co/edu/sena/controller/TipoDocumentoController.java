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

import co.edu.sena.models.entity.TipoDocumento;
import co.edu.sena.models.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/tipodocumento")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TipoDocumentoController {

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@GetMapping("/{id}")
	public Optional<TipoDocumento> buscarPorId(@PathVariable Integer id) {
		
		return tipoDocumentoService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<TipoDocumento> listarTodos(){
		
		return tipoDocumentoService.findAll();
	}
	
	@PostMapping
	public TipoDocumento guardar(@RequestBody TipoDocumento td) {
		
		return tipoDocumentoService.save(td);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		tipoDocumentoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public TipoDocumento actualizar(@RequestBody TipoDocumento td, @PathVariable Integer id) {
		
		TipoDocumento tdEnBD = tipoDocumentoService.findById(id).get();
		
		tdEnBD.setNombre(td.getNombre());
		
		return tipoDocumentoService.save(tdEnBD);
		
	}
}
