package ionic.crud;

import ionic.crud.Models.Student;
import ionic.crud.Services.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentRepository.save(new Student(1L, "Saurav", "Srivastava", "Sarnath", ""))
	}
}
