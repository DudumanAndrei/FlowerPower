package BeaureaticSystems.counter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private CounterService counterService;

    @PostMapping()
    public ResponseEntity<Counter> createCounter(@RequestBody Counter counter) {
        counterService.createCounter(counter);
        return new ResponseEntity<>(counter, HttpStatus.CREATED);
    }
}
