package ionic.crud.Controllers;

import ionic.crud.Models.Student;
import ionic.crud.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student registerUser(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}

