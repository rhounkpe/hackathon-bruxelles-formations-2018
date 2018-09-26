package brussels.smartcity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloCtrl {

    @GetMapping()
    public String hello() {
        return "Hello from Team 5";
    }
}
