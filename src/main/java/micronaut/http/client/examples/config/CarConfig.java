package micronaut.http.client.examples.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.http.client.HttpClientConfiguration;
import io.micronaut.runtime.ApplicationConfiguration;

@ConfigurationProperties("client")
public class CarConfig extends HttpClientConfiguration {

    private  ConnectionPoolConfiguration connectionPoolConfiguration;

    private String retrieve;

    public String add;

    public String getRetrieve() {
        return retrieve;
    }

    public void setRetrieve(String retrieve) {
        this.retrieve = retrieve;
    }


    public CarConfig(
            final ApplicationConfiguration applicationConfiguration,
            final ConnectionPoolConfiguration connectionPoolConfiguration) {
        super(applicationConfiguration);
        this.connectionPoolConfiguration = connectionPoolConfiguration;
    }


    @Override
    public ConnectionPoolConfiguration getConnectionPoolConfiguration() {
        return connectionPoolConfiguration;
    }
}
