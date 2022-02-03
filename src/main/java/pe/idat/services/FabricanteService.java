package pe.idat.services;

import java.util.Collection;

import pe.idat.entity.Fabricante;

public interface FabricanteService 
{
	public abstract void insert(Fabricante fabricante);
	public abstract void update(Fabricante fabricante);
	public abstract void delete(Integer fabricanteId);
	public abstract Fabricante findById(Integer fabricanteId);
	public abstract Collection<Fabricante> findAll();
}
