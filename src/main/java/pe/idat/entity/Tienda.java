package pe.idat.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tienda")
public class Tienda
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tiendaId;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 9)
	private Integer telefono;

	@Column(length = 100)
	private String direccion;
	
	@OneToMany(mappedBy = "tienda")
    private List<Fabricante>fabricante;
	
	public Tienda() {
		// TODO Auto-generated constructor stub
	}

	public Tienda(Integer tiendaId, String nombre, Integer telefono, String direccion) {
		super();
		this.tiendaId = tiendaId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Integer getTiendaId() {
		return tiendaId;
	}

	public void setTiendaId(Integer tiendaId) {
		this.tiendaId = tiendaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
