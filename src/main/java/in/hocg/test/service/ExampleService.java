package in.hocg.test.service;

import in.hocg.test.entity.Example;

import java.util.Optional;

/**
 * @author hocgin
 */
public interface ExampleService {
    
    String worked();
    
    Optional<Example> findById(Long id);
}
