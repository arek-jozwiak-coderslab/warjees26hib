package pl.coderslab.books;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher book) {
        entityManager.persist(book);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }


    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT p from Publisher p");
        return query.getResultList();
    }
}
