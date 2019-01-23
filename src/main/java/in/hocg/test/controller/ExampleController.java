package in.hocg.test.controller;

import in.hocg.test.service.ExampleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hocgin
 */
@RestController
@AllArgsConstructor
@RequestMapping("example")
public class ExampleController {
    
    private final ExampleService exampleService;
    
    @GetMapping("worked")
    public ResponseEntity<String> worked() {
        return ResponseEntity.ok(exampleService.worked());
    }
}
