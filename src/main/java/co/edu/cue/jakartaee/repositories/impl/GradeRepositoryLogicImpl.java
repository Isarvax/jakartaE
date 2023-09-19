package co.edu.cue.jakartaee.repositories.impl;

import co.edu.cue.jakartaee.domain.enums.Career;
import co.edu.cue.jakartaee.domain.model.Grade;
import co.edu.cue.jakartaee.domain.model.Student;
import co.edu.cue.jakartaee.exceptions.UniversityException;
import co.edu.cue.jakartaee.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class GradeRepositoryLogicImpl implements Repository<Grade> {
    private List<Grade> grades;

    public GradeRepositoryLogicImpl() {
        Grade s1 = new Grade(1,1);
        Grade s2 = new Grade(2,2);
        Grade s3 = new Grade(3,4);
        grades = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<Grade> listar() {
        return grades;
    }

    @Override
    public Grade porId(Long id) {
        return grades.stream()
                .filter(e->id.equals(e.getId()))
                .findFirst()
                .orElseThrow(()-> new UniversityException("Grade not found"));
    }

    @Override
    public void guardar(Grade student) {
        grades.add(student);
    }

    @Override
    public void eliminar(Long id) {
        grades.removeIf(e->e.getId().equals(id));
    }
}
