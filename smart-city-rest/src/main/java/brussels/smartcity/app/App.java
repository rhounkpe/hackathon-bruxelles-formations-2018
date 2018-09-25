package brussels.smartcity.app;

import brussels.smartcity.model.Measurement;
import brussels.smartcity.repository.IMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Bootstrap the app
 *
 */

@SpringBootApplication
public class App 
{


    @Autowired
    private IMeasurementRepository measurementRepository;

    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Measurement measurement = new Measurement();
            measurementRepository.save(measurement);
        };
    }
}
