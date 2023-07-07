package app.repository;

import app.entity.Order;
import app.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {


    @PersistenceUnit
    private EntityManagerFactory emf;


    @Override
    public Order getById(Long id) {
        return doInTxReturning(em ->
                em.createQuery(
                        "Select o from Order o join fetch o.products where o.id =: id",
                                Order.class)
                        .setParameter("id", id)
                        .getSingleResult());
    }

    @Override
    public List<Order> getAllOrders() {
        return doInTxReturning(em ->
            em.createQuery("Select o from Order o join fetch o.products", Order.class)
                    .getResultList());
    }

    @Override
    public void addOrder(Order order) {
        doInTxReturning(em -> {
            em.persist(order);
            return null;
        });
    }

    @Override
    public void delete(Long id) {
        doInTxReturning(em -> {
            Order order = em.find(Order.class, id);
            em.remove(order);
            return null;
        });
    }

    private <T> T doInTxReturning(Function<EntityManager, T> function) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            T result = function.apply(em);
            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            throw new QueryException("Error occurred while performing query!", e);
        } finally {
            em.close();
        }
    }
}
