package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
public class CarService implements web.service.Service<Car> {

    private CarDao carDao;
    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car getById(int id) {
        return carDao.getById(id);
    }

    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public void update(Car updateCar) {
        carDao.update(updateCar);
    }

    @Override
    public void delete(int id) {
        carDao.delete(id);
    }
}
