package ionic.crud.Services;

import ionic.crud.Models.Student;
import ionic.crud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@EnableMongoRepositories("ionic.crud.Repository")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    //Create
    public Student addStudent(Student student) {
        student.setId(UUID.randomUUID().toString().split("-")[0]);
        return studentRepository.save(student);
    }

    //Read
    public Student findById(String id) {
        return studentRepository.findById(id).get(); //.get() because it returns optional class;
    }
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByfirstName(String firstName) {
        return studentRepository.getStudentsByFirstName(firstName);
    }

    //Update
    public Student updateStudent(Student student) {
        //get student info
        Student st = findById(student.getId());

        //now update student info
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        st.setAddress(student.getAddress());
        st.setPhoneNo(student.getPhoneNo());

        //now save it in the database
        return studentRepository.save(st);
    }

    //Delete
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
    public void deleteStudent(Student student) {
        String studentId = student.getId();
        deleteStudentById(studentId);
    }
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }
}
