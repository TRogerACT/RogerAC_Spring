package pe.idat.services;

import java.util.Collection;

import pe.idat.entity.Tienda;

public interface TiendaService 
{
	public abstract void insert(Tienda tienda);
	public abstract void update(Tienda tienda);
	public abstract void delete(Integer tiendaId);
	public abstract Tienda findById(Integer tiendaId);
	public abstract Collection<Tienda> findAll();
}
