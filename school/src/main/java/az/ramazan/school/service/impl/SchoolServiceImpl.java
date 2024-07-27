package az.ramazan.school.service.impl;

import az.ramazan.school.client.StudentClient;
import az.ramazan.school.entity.School;
import az.ramazan.school.repository.SchoolRepository;
import az.ramazan.school.dto.FullSchoolResponse;
import az.ramazan.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);

    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

}



