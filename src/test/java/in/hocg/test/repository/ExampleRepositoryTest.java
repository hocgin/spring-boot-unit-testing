package in.hocg.test.repository;

import in.hocg.basic.AbstractSpringBootTest;
import in.hocg.test.entity.Example;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

public class ExampleRepositoryTest extends AbstractSpringBootTest {
    
    @Autowired
    private ExampleRepository exampleRepository;
    
    /**
     * 直接进行测试
     */
    @Test
    public void count() {
        long count = exampleRepository.count();
        Assert.assertEquals(count, 0);
    }
    
    /**
     * 1. 进行数据填充
     * 2. 执行单元测试
     * 3. 数据清理
     */
    @Test
    @Sql(scripts = "/sql/test-example.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Sql(scripts = "/sql/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void count2() {
        long count = exampleRepository.count();
        Assert.assertEquals(count, 2);
    }
    
    /**
     * 该单元测试会在测试结束对测试数据进行回滚
     */
    @Test
    @Transactional
    public void insert() {
        Example example = new Example();
        example.setValue("666");
        exampleRepository.save(example);
        Assert.assertNotNull(example.getId());
    }
    
}