package co.edu.cue.jakartaee.repositories.impl;

import co.edu.cue.jakartaee.domain.enums.Career;
import co.edu.cue.jakartaee.domain.model.Student;
import co.edu.cue.jakartaee.exceptions.UniversityException;
import co.edu.cue.jakartaee.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryLogicImpl implements Repository<Student> {
    private List<Student> students;

    public StudentRepositoryLogicImpl() {
        Student s1 = new Student(1,"Monica", Career.SOFTWARE);
        Student s2 = new Student(2,"Pepe", Career.SOFTWARE);
        Student s3 = new Student(3,"Juan", Career.INDUSTRIAL);
        students = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<Student> listar() {
        return students;
    }

    @Override
    public Student porId(Long id) {
        return students.stream()
                .filter(e->id.equals(e.getId()))
                .findFirst()
                .orElseThrow(()-> new UniversityException("Student not found"));
    }

    @Override
    public void guardar(Student student) {
        students.add(student);
    }

    @Override
    public void eliminar(Long id) {
        students.removeIf(e->e.getId().equals(id));
    }
}