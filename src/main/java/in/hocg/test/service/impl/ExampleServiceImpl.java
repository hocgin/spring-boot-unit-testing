package in.hocg.test.service.impl;

import in.hocg.test.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * @author hocgin
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String worked() {
        return "worked";
    }
}
