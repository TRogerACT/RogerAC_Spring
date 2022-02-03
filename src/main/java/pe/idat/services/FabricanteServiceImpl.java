package pe.idat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.entity.Fabricante;
import pe.idat.repository.FabricanteRepository;


@Service
public class FabricanteServiceImpl implements FabricanteService
{
	@Autowired
	private FabricanteRepository repository;

	@Override
	@Transactional
	public void insert(Fabricante fabricante) {
		repository.save(fabricante);
	}

	@Override
	@Transactional
	public void update(Fabricante fabricante) {
		repository.save(fabricante);		
	}

	@Override
	@Transactional
	public void delete(Integer fabricanteId) {
		repository.deleteById(fabricanteId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Fabricante findById(Integer fabricanteId) {
		return repository.findById(fabricanteId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Fabricante> findAll() {
		return repository.findAll();
	}
}
