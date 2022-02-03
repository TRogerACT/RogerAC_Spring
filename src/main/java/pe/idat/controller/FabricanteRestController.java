package pe.idat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.Fabricante;
import pe.idat.services.FabricanteService;

@RestController
@RequestMapping("/fabricante")
public class FabricanteRestController 
{
	
	@Autowired
	private FabricanteService fabricanteService;
	
	public FabricanteRestController() {		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<Fabricante> listDb=fabricanteService.findAll();
		
		if(listDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(listDb,HttpStatus.OK);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Fabricante fabricante)
	{
		fabricanteService.insert(fabricante);
		return new ResponseEntity<>("////REGISTRADO////",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{fabricanteId}")
	public ResponseEntity<?> editar_PUT(@PathVariable Integer fabricanteId,@RequestBody Fabricante fabricante)
	{
		Fabricante fabricanteDb=fabricanteService.findById(fabricanteId);
		
		if(fabricanteDb!=null)
		{
			fabricanteDb.setNombre(fabricante.getNombre());
			fabricanteDb.setApellidoPaterno(fabricante.getApellidoPaterno());
			fabricanteDb.setApellidoMaterno(fabricante.getApellidoMaterno());
			fabricanteDb.setTelefono(fabricante.getTelefono());
			fabricanteDb.setDireccion(fabricante.getDireccion());
			fabricanteDb.setTienda(fabricante.getTienda());
			
			fabricanteService.update(fabricanteDb);
			return new ResponseEntity<>("////ACTUALIZADO////",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/eliminar/{fabricanteId}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer fabricanteId)
	{
		Fabricante fabricanteDb=fabricanteService.findById(fabricanteId);
		
		if(fabricanteDb!=null)
		{
			fabricanteService.delete(fabricanteId);
			return new ResponseEntity<>("////ELIMINADO////",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{fabricanteId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer fabricanteId)
	{
		Fabricante fabricanteDb=fabricanteService.findById(fabricanteId);
		
		if(fabricanteDb!=null)
		{
			return new ResponseEntity<>(fabricanteDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
}













