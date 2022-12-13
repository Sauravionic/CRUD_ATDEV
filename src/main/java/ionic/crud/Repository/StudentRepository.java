package ionic.crud.Repository;

import ionic.crud.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    //Custom Read Methods
    public List<Student> getStudentsByFirstName(String firstName);
}
