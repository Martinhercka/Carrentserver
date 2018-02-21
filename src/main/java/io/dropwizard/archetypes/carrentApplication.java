package io.dropwizard.archetypes;

import io.dropwizard.Application;
import io.dropwizard.archetypes.db.MySQL;
import io.dropwizard.archetypes.resources.Car;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;



public class carrentApplication extends Application<carrentConfiguration> {

    public static void main(final String[] args) throws Exception {
        new carrentApplication().run(args);
        MySQL dbs = new MySQL();



    }

    @Override
    public String getName() {
        return "carrent";
    }

    @Override
    public void initialize(final Bootstrap<carrentConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final carrentConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new io.dropwizard.archetypes.resources.HelloWorld());
        environment.jersey().register(new Car());
    }

}
