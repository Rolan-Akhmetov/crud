package web.service;

import web.models.Car;

import java.util.List;

public interface Service {
    public List<Car> getAll();
    public Car getById(int id);
    public void save(Car car);
    public void update(int id, Car updateCar);
    public void delete(int id);



}
