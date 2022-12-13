package ionic.crud.Services;

import ionic.crud.Models.Student;

import java.util.List;

public interface StudentService {
    //Create
    public Student addStudent(Student student);

    //Read
    public List<Student> findAllStudent();
    public List<Student> getStudentsByfirstName(String firstName);

    //Update
    public Student updateStudent(Student student);

    //Delete
    public void deleteStudent(Student student);
}
