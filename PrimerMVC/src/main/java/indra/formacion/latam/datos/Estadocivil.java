package indra.formacion.latam.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadosciviles database table.
 * 
 */
@Entity
@Table(name="estadosciviles")
@NamedQuery(name="Estadocivil.findAll", query="SELECT e FROM Estadocivil e")
public class Estadocivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to DatoPersonal
	@OneToMany(mappedBy="estadoscivile")
	private List<DatoPersonal> datosPersonales;

	public Estadocivil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DatoPersonal> getDatosPersonales() {
		return this.datosPersonales;
	}

	public void setDatosPersonales(List<DatoPersonal> datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public DatoPersonal addDatosPersonale(DatoPersonal datosPersonale) {
		getDatosPersonales().add(datosPersonale);
		datosPersonale.setEstadoscivile(this);

		return datosPersonale;
	}

	public DatoPersonal removeDatosPersonale(DatoPersonal datosPersonale) {
		getDatosPersonales().remove(datosPersonale);
		datosPersonale.setEstadoscivile(null);

		return datosPersonale;
	}

}