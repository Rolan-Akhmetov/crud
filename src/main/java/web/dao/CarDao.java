package web.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class CarDao{
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public List<Car> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Car> cars = session.createQuery("select c from Car c", Car.class).getResultList();
        Collections.sort(cars, Comparator.comparing(Car::getModel));
        return cars;
    }


    public Car getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }


    public void save(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }


    public void update(Car updateCar) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updateCar);
    }


    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Car.class,id));
    }
}