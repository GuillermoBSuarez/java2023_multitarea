package service;

import static helpers.EntityManagerLocator.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Pedido;

public class PedidoServiceImpl implements PedidoService {
	
	public List<Pedido> pedidosTienda(String tienda) {
		return getEntityManager()
				.createQuery("select p from Pedido p where p.tienda = ?1", Pedido.class)
				.setParameter(1, tienda)
				.getResultList();
	}
	
	public List<String> tiendas() {
		return getEntityManager()
				.createQuery("select p from Pedido p", Pedido.class)
				.getResultStream()
				.map(p->p.getTienda())
				.distinct()
				.sorted()
				.toList();
	}
	
	@Override
	public void guardarPedido(Pedido pedido) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pedido);
		et.commit();
	} 
}