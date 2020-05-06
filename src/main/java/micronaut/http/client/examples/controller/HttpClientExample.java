package micronaut.http.client.examples.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import micronaut.http.client.examples.domain.Car;
import micronaut.http.client.examples.service.CarGetClient;
import micronaut.http.client.examples.service.CarPostClient;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;

@Controller("/v1")
public class HttpClientExample {

    CarGetClient carClient;

    CarPostClient carPostClient;

    @Inject
    public HttpClientExample(CarGetClient carClient, CarPostClient carPostClient) {
        this.carClient = carClient;
        this.carPostClient = carPostClient;
    }

    @Get("/car")
    public String getCarInformation() {
        return carClient.getCar();
    }

    @Get(uri = "/cars", produces = MediaType.TEXT_PLAIN)
    public String getCarInformation(String type) {
        return carClient.getCarType(type);
    }

    @Get(uri = "/reactive_cars", produces = MediaType.TEXT_PLAIN)
    public Single<String> getReactiveCarInformation(String type) {
        return carClient.getSingleCarType(type);
    }

    @Post(uri = "/add")
    public Car addCar(@Body Car car) {

        return carPostClient.addCar(car);
    }
}
