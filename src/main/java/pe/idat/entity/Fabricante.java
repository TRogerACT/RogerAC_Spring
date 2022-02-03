package pe.idat.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fabricante")
public class Fabricante
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fabricanteId;
	
	@Column(length = 100)
	private String nombre;

	@Column(length = 100)
	private String apellidoPaterno;

	@Column(length = 100)
	private String apellidoMaterno;
	
	@Column(length = 9)
	private Integer telefono;

	@Column(length = 100)
	private String direccion;
	
    @ManyToOne
    @JoinColumn(name="tiendaId", nullable=false)
    private Tienda tienda;
	
	public Fabricante() {
		// TODO Auto-generated constructor stub
	}

	public Fabricante(Integer fabricanteId, String nombre, String apellidoPaterno, String apellidoMaterno,
			Integer telefono, String direccion) {
		super();
		this.fabricanteId = fabricanteId;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Integer getFabricanteId() {
		return fabricanteId;
	}

	public void setFabricanteId(Integer fabricanteId) {
		this.fabricanteId = fabricanteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}


	
	
	
}
	
	
