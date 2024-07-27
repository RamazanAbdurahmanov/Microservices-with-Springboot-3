package az.ramazan.student.service;

import az.ramazan.student.entity.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    List<Student> findAllStudents();

    List<Student> findAllStudentsBySchool(Long schoolId);
}
