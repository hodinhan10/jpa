package com.example.demojpa.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demojpa.entity.Student;
import com.example.demojpa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService sv;

    public StudentController(StudentService sv) {
        this.sv = sv;
    }

    @GetMapping
    public List<Student> getAll() {
        return sv.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return sv.getById(id);
    }

    @PostMapping
    public Student add(@RequestBody Student e) {
        return sv.add(e);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student e) {
        return sv.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sv.delete(id);
    }
}
