package co.edu.cue.jakartaee.repositories.impl;

import co.edu.cue.jakartaee.domain.enums.Career;
import co.edu.cue.jakartaee.domain.model.Student;
import co.edu.cue.jakartaee.domain.model.Teacher;
import co.edu.cue.jakartaee.exceptions.UniversityException;
import co.edu.cue.jakartaee.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryLogicImpl implements Repository<Teacher> {
    private List<Teacher> teachers;

    public TeacherRepositoryLogicImpl() {
        Teacher s1 = new Teacher(1,"Isabella","soybatman123@gmail.com");
        Teacher s2 = new Teacher(2,"Nicolas", "toroide@gmail.com");
        Teacher s3 = new Teacher(3,"Juan", "dianalol4@gmail.com");
        teachers = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<Teacher> listar() {
        return teachers;
    }

    @Override
    public Teacher porId(Long id) {
        return teachers.stream()
                .filter(e->id.equals(e.getId()))
                .findFirst()
                .orElseThrow(()-> new UniversityException("Teacher not found"));
    }

    @Override
    public void guardar(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void eliminar(Long id) {
        teachers.removeIf(e->e.getId().equals(id));
    }
}
