package sub.optimal.jsonrpc.impl;

import sub.optimal.jsonrpc.MyService;
import sub.optimal.jsonrpc.domains.Car;

public class MyServiceImpl implements MyService {

    @Override
    public String sayHello(String name) {
        return "Hello world, " + name;
    }

    @Override
    public Car findCar(Integer id) {
        Car result = new Car();
        result.setId(id);
        result.setEnabled(id % 1 == 1);
        result.setName("Name" + 1);
        return result;
    }

    @Override
    public Integer saveCar(Car car) {
        return car.getId();
    }
}
