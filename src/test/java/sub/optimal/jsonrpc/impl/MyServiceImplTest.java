package sub.optimal.jsonrpc.impl;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sub.optimal.jsonrpc.MyService;
import sub.optimal.jsonrpc.domains.Car;

/**
 * Integration tests:
 *
 * <h2>jsonrpc4j documentation</h2>
 *
 * https://github.com/SubOptimal/spring-boot-jsonrpc4j
 *
 * @author Pavel Ponec
 */
public class MyServiceImplTest {

    private final String serverUrl = "http://localhost:8080";

    /**
     * Test of sayHelloWorld method, of class MyServiceImpl.
     * <h3>Usage:</h3>      {@code curl -v -H "Content-Type: application/json" -d '{"id":0, "method":"sayHello", "params":["pop"]}' http://localhost:8080/rpc/myservice 
     * }
     */
    @Test
    public void sayHello() throws MalformedURLException {
        MyServiceImpl localService = new MyServiceImpl();
        String expResult = localService.sayHello("pop");

        MyService clientService = getClientService();
        String result = clientService.sayHello("pop");

        assertEquals(expResult, result);
    }

    /**
     * Test of findCar method, of class MyServiceImpl.
     *
     * <h3>Usage:</h3>      
     * {@code curl -v -H "Content-Type: application/json" -d '{"id":0, "method":"findCar", "params":[1]}' http://localhost:8080/rpc/myservice 
     * }
     */
    @Test
    public void findCar() throws MalformedURLException {
        MyServiceImpl localService = new MyServiceImpl();
        Car expResult = localService.findCar(1);
        Car result = getClientService().findCar(1);

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of findCar method, of class MyServiceImpl.
     * <h3>Usage:</h3>      
     * {@code curl -v -H "Content-Type: application/json" -d '{"id":0, "method":"saveCar", "params":[{"id":2,"name":"test","enabled":true}]}' http://localhost:8080/rpc/myservice 
     * }
     */
    @Test
    public void saveCar() throws MalformedURLException {
        MyServiceImpl localService = new MyServiceImpl();

        Car car = createCar(2);
        Integer id = getClientService().saveCar(car);
        assertEquals(2, id);
    }

    private MyService getClientService() throws MalformedURLException {
        JsonRpcHttpClient client = new JsonRpcHttpClient(
                new URL(serverUrl + MyService.ENDPOINT));
        MyService clientService = ProxyUtil.createClientProxy(
                getClass().getClassLoader(),
                MyService.class,
                client);
        return clientService;
    }

    private Car createCar(Integer id) {
        Car result = new Car();
        result.setId(id);
        result.setEnabled(true);
        result.setName("test");

        return result;
    }

}
