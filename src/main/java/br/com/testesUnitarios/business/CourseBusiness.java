package br.com.testesUnitarios.business;

import br.com.testesUnitarios.service.stubs.CourseService;

import java.util.ArrayList;
import java.util.List;

// SUT - System (method) under test
public class CourseBusiness {

    // Course Service is a dependency
    private CourseService service;

    public CourseBusiness (CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCourserRelatedToSpring(String student){
        var filtedCourses = new ArrayList<String>();
        if("Foo Bar".equals(student)) return filtedCourses;
        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses){
            if(course.contains("Spring") || course.contains("spring")){
                filtedCourses.add(course);
            }
        }

        return filtedCourses;
    }

    public void deleteCoursesNoRelatedToSpring(String student){
        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses){
            if(!course.contains("Spring") && !course.contains("spring")){
                service.deleteCourse(course);
            }
        }
    }
}
