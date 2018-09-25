package brussels.smartcity.rest;

import brussels.smartcity.model.Measurement;
import brussels.smartcity.repository.IMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementRestCtrl {

    @Autowired
    private IMeasurementRepository measurementRepository;

    @GetMapping(value = {"", "/"})
    private List<Measurement> getAll() {
        return measurementRepository.findAll();
    }
}
