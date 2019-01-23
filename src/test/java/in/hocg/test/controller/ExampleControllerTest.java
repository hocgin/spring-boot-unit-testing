package in.hocg.test.controller;

import in.hocg.basic.AbstractSpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@Slf4j
public class ExampleControllerTest extends AbstractSpringBootTest {
    
    /**
     * 直接进行 Controller 的单元测试
     */
    @Test
    public void worked() {
        URI uri = uri().resolve("/example/worked");
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("worked", response.getBody());
    }
}