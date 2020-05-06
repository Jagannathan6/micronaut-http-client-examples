package micronaut.http.client.examples.service;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import micronaut.http.client.examples.config.CarConfig;
import micronaut.http.client.examples.domain.Car;

@Client(
        value = "${client.add}",
        path = "/v2/car",
        configuration = CarConfig.class)
public interface CarPostClient {

    @Post
    public Car addCar(@Body Car car);

}
