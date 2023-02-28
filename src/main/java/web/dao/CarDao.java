package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;

import java.util.List;

@Repository
public class CarDao{
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Car> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Car c", Car.class).
                getResultList();
    }

    @Transactional(readOnly = true)
    public Car getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    @Transactional
    public void save(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.save(car);
    }

    @Transactional
    public void update(int id, Car updateCar) {
        Session session = sessionFactory.getCurrentSession();
        Car carToBeUpdated = session.get(Car.class, id);

        carToBeUpdated.setModel(updateCar.getModel());
        carToBeUpdated.setYearOfRelease(updateCar.getYearOfRelease());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Car.class,id));
    }
}