package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Pedido;

public interface FormacionService {

	void actualizarDatos();

	List<Pedido> listadoCursos();
	
	List<Pedido> listadoCursos(LocalDate fechaInicio, LocalDate fechaFin);

	List<Alumno> listadoAlumnos(int idCurso);

	boolean borrarAlumno(String dni);

}