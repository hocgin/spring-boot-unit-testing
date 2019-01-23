package in.hocg.test.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceImplTest {
    @Mock
    private ExampleServiceImpl exampleService;
    
    /**
     * 简单的 Mock
     */
    @Test
    public void worked() {
        when(exampleService.worked()).thenReturn("ok");
        Assert.assertEquals(exampleService.worked(), "ok");
    }
}