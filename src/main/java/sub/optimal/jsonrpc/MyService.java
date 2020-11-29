package sub.optimal.jsonrpc;

import sub.optimal.jsonrpc.domains.Car;

public interface MyService {
    
    public static final String ENDPOINT = "/rpc/myservice";

    String sayHello(String name);
    
    Car findCar(Integer id);
    
    Integer saveCar(Car car);
}
