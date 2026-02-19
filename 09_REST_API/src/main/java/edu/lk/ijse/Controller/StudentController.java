package edu.lk.ijse.Controller;


import edu.lk.ijse.dto.Studentdto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @PostMapping(consumes = "application/json")
    public String saveCustomer(@RequestBody Studentdto studentdto) {
        return "success -> "
                + studentdto.getId()
                + studentdto.getName()
                + studentdto.getAddress();
    }
}
