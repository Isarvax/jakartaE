package co.edu.cue.jakartaee.repositories.impl;

import co.edu.cue.jakartaee.domain.model.Grade;
import co.edu.cue.jakartaee.domain.model.Subject;
import co.edu.cue.jakartaee.exceptions.UniversityException;
import co.edu.cue.jakartaee.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryLogicImpl implements Repository<Subject> {
    private List<Subject> subjects;

    public SubjectRepositoryLogicImpl() {
        Subject s1 = new Subject(1,"Matematicas");
        Subject s2 = new Subject(2,"Ingles");
        Subject s3 = new Subject(3,"Fisica");
        subjects = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<Subject> listar() {
        return subjects;
    }

    @Override
    public Subject porId(Long id) {
        return subjects.stream()
                .filter(e->id.equals(e.getId()))
                .findFirst()
                .orElseThrow(()-> new UniversityException("Subject not found"));
    }

    @Override
    public void guardar(Subject student) {
        subjects.add(student);
    }

    @Override
    public void eliminar(Long id) {
        subjects.removeIf(e->e.getId().equals(id));
    }
}
