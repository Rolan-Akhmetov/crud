package web.CarService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceList {
    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car(1, "Mitsubishi GTO", 1994));
        carList.add(new Car(2, "BMW X5", 2007));
        carList.add(new Car(3, "Mercedes E200", 1999));
        carList.add(new Car(4, "Lexus IS250", 2006));
        carList.add(new Car(5, "Datsun ON-DO", 2018));


    }

    public List<Car> index() {
        return carList;
    }
    public Car show(int id){
        return carList.stream().filter(e->e.getId()==id).findAny().orElse(null);
    }

}
