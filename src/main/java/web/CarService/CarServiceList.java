package web.CarService;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CarServiceList {
    private final List<Car> carList =new ArrayList<>();;

    {
        carList.add(new Car(1, "Mitsubishi GTO", 1994));
        carList.add(new Car(2, "BMW X5", 2007));
        carList.add(new Car(3, "Mercedes E200", 1999));
        carList.add(new Car(4, "Lexus IS250", 2006));
        carList.add(new Car(5, "Datsun ON-DO", 2018));
    }
    public List<Car> getAll() {
        return carList;
    }
    public Car getById(int id){
        return carList.stream().filter(e->e.getId()==id).findAny().orElse(null);
    }
    public List<Car> getCarCount(int count){
        if (!Objects.equals(count,0)) {
            return carList.stream().limit(count).collect(Collectors.toList());
        }
        return carList;
    }
}
