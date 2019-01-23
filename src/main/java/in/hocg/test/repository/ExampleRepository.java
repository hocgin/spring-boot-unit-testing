package in.hocg.test.repository;

import in.hocg.test.entity.Example;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hocgin
 */
@Repository
public interface ExampleRepository extends PagingAndSortingRepository<Example, Long> {

}
