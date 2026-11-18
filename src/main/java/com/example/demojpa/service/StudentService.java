package com.example.demojpa.service;
import org.springframework.stereotype.Service;

import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository rp;

    public StudentService(StudentRepository rp) {
        this.rp = rp;
    }

    public List<Student> getAll() {
        return rp.findAll();
    }

    public Student getById(Long id) {
        return rp.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên"));
    }

    public Student add(Student e) {
        return rp.save(e);
    }

    public Student update(Long id, Student e) {
        Student s = getById(id);
        s.setName(e.getName());
        s.setEmail(e.getEmail());
        s.setAge(e.getAge());
        return rp.save(s);
    }

    public void delete(Long id) {
        Student s = getById(id);
        rp.delete(s);
    }
}
