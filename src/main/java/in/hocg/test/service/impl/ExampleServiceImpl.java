package in.hocg.test.service.impl;

import in.hocg.test.entity.Example;
import in.hocg.test.repository.ExampleRepository;
import in.hocg.test.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ExampleServiceImpl implements ExampleService {
    
    private final ExampleRepository repository;
    
    @Override
    public String worked() {
        return "worked";
    }
    
    @Override
    public Optional<Example> findById(Long id) {
        return repository.findById(id);
    }
}
