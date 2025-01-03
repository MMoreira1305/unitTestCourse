package br.com.testesUnitarios.service.stubs;

import java.util.List;

public interface CourseService {

    public List<String> retrieveCourses(String student);
    public void deleteCourse(String course);
}
