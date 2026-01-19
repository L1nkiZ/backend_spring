package linkiz.ynov.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import linkiz.ynov.demo.payload.responses.HomeResponse;


@RestController
public class HomeController {
    @GetMapping("/")
    HomeResponse homeResponse() {
        return new HomeResponse("Hello World");
    }
    @GetMapping("/HelloWorld")
    public String home() {
        return homeResponse().getValue();
    }
    
}
