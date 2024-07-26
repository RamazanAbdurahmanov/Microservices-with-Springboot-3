package az.ramazan.school.service.impl;

import az.ramazan.school.entity.School;
import az.ramazan.school.repository.SchoolRepository;
import az.ramazan.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public void saveSchool(School school) {
        schoolRepository.save(school);

    }

    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }
}
