package co.com.sofka.reactivemongodb;

import co.com.sofka.reactivemongodb.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentReactiveRepository extends ReactiveCrudRepository<Student,String> {
}