package ionic.crud.Services;

import ionic.crud.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRepository extends MongoRepository<Student, Long> {
}
