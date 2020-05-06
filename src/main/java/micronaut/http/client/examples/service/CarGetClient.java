package micronaut.http.client.examples.service;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import micronaut.http.client.examples.config.CarConfig;

@Client(
        value = "${client.retrieve}",
        path = "/v1",
        configuration = CarConfig.class)
public interface CarGetClient {

    @Get("car")
    public String getCar();

    @Get("cars?type={type}")
    public String getCarType(String type);

    @Get("cars?type={type}")
    public Single<String> getSingleCarType(String type);
}
