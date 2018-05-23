package indra.formacion.latam.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int edad;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to DatoLaboral
	@ManyToOne
	@JoinColumn(name="datosLaborales_id")
	private DatoLaboral datosLaborale;

	//bi-directional many-to-one association to DatoPersonal
	@ManyToOne
	@JoinColumn(name="datosPersonales_id")
	private DatoPersonal datosPersonale;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresas_id")
	private Empresa empresa;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DatoLaboral getDatosLaborale() {
		return this.datosLaborale;
	}

	public void setDatosLaborale(DatoLaboral datosLaborale) {
		this.datosLaborale = datosLaborale;
	}

	public DatoPersonal getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(DatoPersonal datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}