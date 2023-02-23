package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarService.CarServiceList;
import web.models.Car;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarServiceList carServiceList;

    @Autowired
    public CarController(CarServiceList carServiceList) {
        this.carServiceList = carServiceList;
    }

    @GetMapping("")
    public String cars(Model model) {  // получим все автомобили
        model.addAttribute("cars", carServiceList.index());
        return "cars";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {  // получим машину по id
        model.addAttribute("car", carServiceList.show(id));
        return "show";
    }
    @GetMapping("/count")
    public String count(Model model, @RequestParam(value = "count",required = false) Integer count){
        List<Car> cars = carServiceList.count(count);
        model.addAttribute("cars",cars);

        return "count";
    }

}
