package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
public class PingController {

    @GetMapping
    public ResponseEntity<String> isProgramWorking() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
