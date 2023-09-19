package co.edu.cue.jakartaee.services;

import co.edu.cue.jakartaee.domain.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> listar();

    Teacher porId(Long id);

    void guardar(Teacher t);

    void eliminar(Long id);
}
