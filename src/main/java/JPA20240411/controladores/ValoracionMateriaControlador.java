package JPA20240411.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import JPA20240411.model.Estudiante;
import JPA20240411.model.Materia;
import JPA20240411.model.Profesor;
import JPA20240411.model.ValoracionMateria;


public class ValoracionMateriaControlador extends Controlador{

	public ValoracionMateriaControlador() {
		super("valoracionmateria", ValoracionMateria.class);
	}	

}