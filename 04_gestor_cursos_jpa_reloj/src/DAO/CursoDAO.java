package DAO;

import java.time.LocalDate;
import java.util.List;

import model.Pedido;

public interface CursoDAO {

	boolean existeCurso(int idCurso);

	boolean guardarCurso(Pedido curso);

	List<Pedido> cursos();

	List<Pedido> cursos(LocalDate fechainicio, LocalDate fechafin);
}