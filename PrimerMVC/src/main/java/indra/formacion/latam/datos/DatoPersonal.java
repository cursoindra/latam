package indra.formacion.latam.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datosPersonales database table.
 * 
 */
@Entity
@Table(name="datosPersonales")
@NamedQuery(name="DatoPersonal.findAll", query="SELECT d FROM DatoPersonal d")
public class DatoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Estadocivil
	@ManyToOne
	@JoinColumn(name="idEstadosCiviles")
	private Estadocivil estadoscivile;

	//bi-directional many-to-one association to Hijo
	@ManyToOne
	@JoinColumn(name="idHijjos")
	private Hijo hijo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="datosPersonale")
	private List<Empleado> empleados;

	public DatoPersonal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estadocivil getEstadoscivile() {
		return this.estadoscivile;
	}

	public void setEstadoscivile(Estadocivil estadoscivile) {
		this.estadoscivile = estadoscivile;
	}

	public Hijo getHijo() {
		return this.hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDatosPersonale(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDatosPersonale(null);

		return empleado;
	}

}