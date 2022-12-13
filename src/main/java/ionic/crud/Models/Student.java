package ionic.crud.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;

    public Student(Long id, String firstName, String lastName, String address, String phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}
