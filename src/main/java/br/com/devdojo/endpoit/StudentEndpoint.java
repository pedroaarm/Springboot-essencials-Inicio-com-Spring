package br.com.devdojo.endpoit;


import br.com.devdojo.error.CustonErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/* RestController -- receber requisição e retorna o resultado em json, sem trabalhar com wiew*/
@RestController
@RequestMapping("students")
public class StudentEndpoint {
    private final DateUtil dateutil;

    public StudentEndpoint(DateUtil dateutil) {
        this.dateutil = dateutil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        System.out.println(dateutil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentlist, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getstudantbyid(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index = Student.studentlist.indexOf(student);
        if(index == -1){
            return new ResponseEntity<>(new CustonErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Student.studentlist.get(index), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student) {
        Student.studentlist.add(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
