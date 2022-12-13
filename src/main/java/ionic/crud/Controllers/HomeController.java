package ionic.crud.Controllers;

import ionic.crud.Models.Student;
import ionic.crud.Services.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/register")
    public ResponseEntity registerStudent(@RequestBody Student student) throws Exception {
        /* Request Body:- For Testing
            {
                "firstName": "Saurav",
                "lastName":"Srivastava",
                "address":"Varanasi",
                "phoneno":"345345345"
            }
      */
        System.out.println(student.getFirstName());
        try {
            if (student.getFirstName() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "FirstName Not Found");
            }
            else {
                Student st = studentService.addStudent(student);
                return new ResponseEntity<>(student, HttpStatus.CREATED);
            }
        } catch(ResponseStatusException e) {
            return new ResponseEntity("FirstName Not Found",HttpStatus.BAD_REQUEST);
        }
        catch(Exception e) {
            return new ResponseEntity("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity getStudent(@PathVariable("id") String id) {
         /* Request Parameter:- For Testing
            localhost:8080/api/student/53f94f5f -> dummy data for testing
        */
        try {
            Student student = studentService.findById(id);
            if(student == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Does Not Exists");
            }
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch(ResponseStatusException e) {
            return new ResponseEntity("Student Does Not Exists",HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return new ResponseEntity("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/students")
    public ResponseEntity<List> getAllStudents() {
        /* Request Parameter:- For Testing
            localhost:8080/api/students
         */
        try {
            List<Student> list = studentService.findAllStudent();
            if(list.size() == 0 || list == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Student Exists");
            }
            return new ResponseEntity<List>(list, HttpStatus.OK);
        } catch(ResponseStatusException e) {
            return new ResponseEntity("No Student Exists",HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return new ResponseEntity("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody Student student) {
        /*
            ** Request Parameter:- For Testing
            localhost:8080/api/updateStudent

            ** Request Body:-
            {
                "id": "1",
                "firstName": "Amit",
                "lastName":"Srivastava",
                "address":"Varanasi",
                "phoneno":"345345345"
            }
         */
        try {
            if(student == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Does Not Exists");
            }

            Student updatedStudent = studentService.updateStudent(student);
            if(updatedStudent == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Does Not Exists");
            }

            return new ResponseEntity(updatedStudent, HttpStatus.OK);
        } catch(ResponseStatusException e) {
            return new ResponseEntity("Student Does Not Exist", HttpStatus.NOT_FOUND);
        }
        catch(Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") String id) {
        /* Request Parameter:- For Testing
            localhost:8080/api/delete/53f94f5f -> dummy data for testing
        */
        try {
            Student student = studentService.findById(id);
            if(student == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Does Not Exists");
            }
            studentService.deleteStudentById(id);
            return new ResponseEntity("Deleted", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity("Student Does Not Exist", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllStudents() {
        /* Request Parameter:- For Testing
            localhost:8080/api/deleteAll
         */
        try {
            List<Student> list = studentService.findAllStudent();
            if(list.size() == 0 || list == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Student Exists");
            }
            studentService.deleteAllStudent();
            return new ResponseEntity("Deleted", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity("Student Does Not Exist", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }
}

