package BeaureaticSystems.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;

@RestController
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;

    @PostMapping
    public ResponseEntity<Counter> createCounter(@RequestBody Counter counter) {
        counterService.createCounter(counter);
        return new ResponseEntity<>(counter, HttpStatus.CREATED);
    }
}
