package DAO;

import static helpers.EntityManagerLocator.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Pedido;

public class PedidoDAOImpl implements PedidoDAO {
	@Override
	public void guardarPedido(Pedido pedido) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pedido);
		et.commit();
	} 
}