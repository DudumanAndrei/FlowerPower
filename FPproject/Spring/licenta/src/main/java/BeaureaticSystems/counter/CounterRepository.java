package BeaureaticSystems.counter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Integer> {
}
