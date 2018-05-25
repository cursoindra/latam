package indra.formacion.latam.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datosLaborales database table.
 * 
 */
@Entity
@Table(name="datosLaborales")
@NamedQuery(name="DatoLaboral.findAll", query="SELECT d FROM DatoLaboral d")
public class DatoLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int salario;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="cargos_id")
	private Cargo cargo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="datosLaborale")
	private List<Empleado> empleados;

	public DatoLaboral() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDatosLaborale(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDatosLaborale(null);

		return empleado;
	}
	@Override
	public String toString() {
		
		return getCargo().getDescripcion()+" - "+getSalario();
	}
}