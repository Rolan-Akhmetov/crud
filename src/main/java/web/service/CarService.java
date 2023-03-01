package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
@Transactional
public class CarService{

    private final CarDao carDao;
    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }


    public List<Car> getAll() {
        return carDao.getAll();
    }


    public Car getById(int id) {
        return carDao.getById(id);
    }

    public void save(Car car) {
        carDao.save(car);
    }
    public void update(Car updateCar) {
        carDao.update(updateCar);
    }
    public void delete(int id) {
        carDao.delete(id);
    }
}
