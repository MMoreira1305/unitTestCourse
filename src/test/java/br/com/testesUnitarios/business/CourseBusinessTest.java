package br.com.testesUnitarios.business;

import br.com.testesUnitarios.service.stubs.CourseService;
import br.com.testesUnitarios.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseBusinessTest {
    CourseService mockSerivce;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup(){
        mockSerivce = mock(CourseService.class);
        business = new CourseBusiness(mockSerivce);
        courses = List.of(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock(){
        // Given / Arrange

        when(mockSerivce.retrieveCourses("Matheus"))
                .thenReturn(courses);

        // When / Act
        var filteredCourses = business.retrieveCourserRelatedToSpring("Matheus");

        // Then / Assert
        assertEquals(4, filteredCourses.size());
    }
}
