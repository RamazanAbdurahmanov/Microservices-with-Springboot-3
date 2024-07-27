package az.ramazan.school.service;


import az.ramazan.school.entity.School;
import az.ramazan.school.dto.FullSchoolResponse;

import java.util.List;

public interface SchoolService {
    void saveSchool(School school);

    List<School> findAllSchools();

    FullSchoolResponse findSchoolsWithStudents(Long schoolId);
}
