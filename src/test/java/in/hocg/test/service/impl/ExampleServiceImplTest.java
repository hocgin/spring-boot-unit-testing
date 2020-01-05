package in.hocg.test.service.impl;

import in.hocg.basic.AbstractSpringBootTest;
import in.hocg.test.entity.Example;
import in.hocg.test.repository.ExampleRepository;
import in.hocg.test.service.ExampleService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ExampleServiceImplTest extends AbstractSpringBootTest {
    
    @Autowired
    private ExampleService exampleService;
    
    @MockBean
    private ExampleRepository exampleRepository;
    
    /**
     * [推荐] 简单的 Mock
     */
    @Test
    public void worked() {
        final Example example = new Example();
        example.setId(1L);
        example.setValue("mock");
        
        when(exampleRepository.findById(anyLong())).thenReturn(Optional.of(example));
        
        final Optional<Example> exampleOptional = exampleService.findById(1L);
        Assert.assertTrue(exampleOptional.isPresent());
    }
}