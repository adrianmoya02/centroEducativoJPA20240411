package JPA20240411.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the valoracionmateria database table.
 * 
 */  
@Entity
@NamedQuery(name="ValoracionMateria.findAll", query="SELECT v FROM ValoracionMateria v")
public class ValoracionMateria extends Entidad {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float valoracion;

	private Estudiante estudiante;
	private Materia materia;
	private Profesor profesor;

	public ValoracionMateria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


}
