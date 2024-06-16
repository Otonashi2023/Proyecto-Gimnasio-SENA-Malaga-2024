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

import co.edu.sena.models.entity.FichaAntropo;
import co.edu.sena.models.service.FichaAntropoService;

@RestController
@RequestMapping("/api/fichaantropo")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FichaAntropoController {

	@Autowired
	FichaAntropoService fichaAntropoService;
	
	@GetMapping("/{id}")
	public Optional<FichaAntropo> buscarPorId(@PathVariable BigInteger id) {
		
		return fichaAntropoService.findById(id);		
	}
	
	@GetMapping("/listar")
	public List<FichaAntropo> listarTodos(){
		
		return fichaAntropoService.findAll();
	}
	
	@PostMapping
	public FichaAntropo guardar(@RequestBody FichaAntropo fa) {
		
		return fichaAntropoService.save(fa);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable BigInteger id) {
		
		fichaAntropoService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public FichaAntropo actualizar(@RequestBody FichaAntropo fa, @PathVariable BigInteger id) {
		
		FichaAntropo faEnBD = fichaAntropoService.findById(id).get();
		
		faEnBD.setNumControl(fa.getNumControl());
		faEnBD.setFecha(fa.getFecha());
		faEnBD.setAltura(fa.getAltura());
		faEnBD.setPeso(fa.getPeso());
		faEnBD.setImc(fa.getImc());
		faEnBD.setPersonal(fa.getPersonal());
		faEnBD.setGenero(fa.getGenero());
		faEnBD.setAprendiz(fa.getAprendiz());
				
		return fichaAntropoService.save(faEnBD);
		
	}
}
