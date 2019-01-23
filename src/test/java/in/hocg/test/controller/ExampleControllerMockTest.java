package in.hocg.test.controller;

import in.hocg.basic.AbstractSpringBootTest;
import in.hocg.test.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.net.URI;

import static org.mockito.Mockito.when;

@Slf4j
public class ExampleControllerMockTest extends AbstractSpringBootTest {
    
    @Autowired
    private ExampleController exampleController;
    @Mock
    private ExampleService exampleService;
    private Object exampleServiceRef;
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        exampleServiceRef = ReflectionTestUtils.getField(exampleController, "exampleService");
        ReflectionTestUtils.setField(exampleController, "exampleService", exampleService);
    }
    
    @After
    public void tearDown() throws Exception {
        ReflectionTestUtils.setField(exampleController, "exampleService", exampleServiceRef);
    }
    
    /**
     * 对 Controller 中的 Service 进行 Mock 并执行单元测试
     */
    @Test
    public void worked() {
        when(exampleService.worked()).thenReturn("Mock Data");
        
        
        URI uri = uri().resolve("/example/worked");
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("Mock Data", response.getBody());
    }
}