package in.hocg.test.controller;

import in.hocg.basic.AbstractSpringBootTest;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class ExampleControllerTest extends AbstractSpringBootTest {
    
    /**
     * 直接进行 Controller 的单元测试(1)
     */
    @Test
    public void worked() {
        URI uri = uri().resolve("/example/worked");
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("worked", response.getBody());
    }
    
    /**
     * [推荐] 直接进行 Controller 的单元测试(2)
     */
    @Test
    public void worked2() throws Exception {
        // 构建请求
        mockMvc.perform(MockMvcRequestBuilders.get("/example/worked")
                .accept(MediaType.ALL))
                // 进行结果验证
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(CoreMatchers.equalTo("worked"))
                );
    }
}