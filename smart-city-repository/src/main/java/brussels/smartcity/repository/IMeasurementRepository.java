package brussels.smartcity.repository;

import brussels.smartcity.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMeasurementRepository extends JpaRepository<Measurement, Long> {
}
