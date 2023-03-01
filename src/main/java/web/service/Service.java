package web.service;

import web.models.Car;

import java.util.List;

public interface Service<T> {
    public List<T> getAll();
    public T getById(int id);
    public void save(T t);
    public void update(T t);
    public void delete(int id);



}
