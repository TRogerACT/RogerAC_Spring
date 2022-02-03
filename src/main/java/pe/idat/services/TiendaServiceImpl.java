package pe.idat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Tienda;
import pe.idat.repository.TiendaRepository;

@Service
public class TiendaServiceImpl implements TiendaService
{
	@Autowired
	private TiendaRepository repository;

	@Override
	@Transactional
	public void insert(Tienda tienda) {
		repository.save(tienda);
	}

	@Override
	@Transactional
	public void update(Tienda tienda) {
		repository.save(tienda);		
	}

	@Override
	@Transactional
	public void delete(Integer tiendaId) {
		repository.deleteById(tiendaId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Tienda findById(Integer tiendaId) {
		return repository.findById(tiendaId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Tienda> findAll() {
		return repository.findAll();
	}
}
