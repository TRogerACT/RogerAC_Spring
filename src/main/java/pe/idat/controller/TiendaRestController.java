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

import pe.idat.entity.Tienda;
import pe.idat.services.TiendaService;



@RestController
@RequestMapping("/tienda")
public class TiendaRestController 
{
	
	@Autowired
	private TiendaService tiendaService;
	
	public TiendaRestController() {		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<Tienda> listDb=tiendaService.findAll();
		
		if(listDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(listDb,HttpStatus.OK);
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Tienda tienda)
	{
		tiendaService.insert(tienda);
		return new ResponseEntity<>("////REGISTRADO////",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{tiendaId}")
	public ResponseEntity<?> editar_PUT(@PathVariable Integer tiendaId,@RequestBody Tienda tienda)
	{
		Tienda tiendaDb=tiendaService.findById(tiendaId);
		
		if(tiendaDb!=null)
		{
			tiendaDb.setNombre(tienda.getNombre());
			tiendaDb.setTelefono(tienda.getTelefono());
			tiendaDb.setNombre(tienda.getNombre());
			tiendaDb.setDireccion(tienda.getDireccion());
						
			tiendaService.update(tiendaDb);
			return new ResponseEntity<>("////ACTUALIZADO////",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/eliminar/{tiendaId}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer tiendaId)
	{
		Tienda tiendaDb=tiendaService.findById(tiendaId);
		
		if(tiendaDb!=null)
		{
			tiendaService.delete(tiendaId);
			return new ResponseEntity<>("////ELIMINADO////",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/buscar/{tiendaId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer tiendaId)
	{
		Tienda tiendaDb=tiendaService.findById(tiendaId);
		
		if(tiendaDb!=null)
		{
			return new ResponseEntity<>(tiendaDb,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("////NO EXISTE////",HttpStatus.NOT_FOUND);
	}
}













