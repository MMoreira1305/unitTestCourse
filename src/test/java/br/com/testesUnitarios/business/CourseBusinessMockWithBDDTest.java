package br.com.testesUnitarios.business;

import br.com.testesUnitarios.service.stubs.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CourseBusinessMockWithBDDTest {
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

        given(mockSerivce.retrieveCourses("Matheus"))
                .willReturn(courses);

        // When / Act
        var filteredCourses = business.retrieveCourserRelatedToSpring("Matheus");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete courses not related to spring using mockito should call method deleteCourse()")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourse(){
        // Given / Arrange
        given(mockSerivce.retrieveCourses("Matheus"))
                .willReturn(courses);

        // When / Act
        business.deleteCoursesNoRelatedToSpring("Matheus");

        // Then / Assert
        // Este metodo times() é utilizado para definir a quantidade de vezes que quero rodar essa verificação
        verify(mockSerivce, times(1))
                .deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        verify(mockSerivce)
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockSerivce)
                .deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        // Metodo never é utilizado para dizer que isso nunca vai acontecer
        verify(mockSerivce, never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
    }

    @DisplayName("Delete courses not related to spring using mockito should call method deleteCourse()")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourseV2(){
        // Given / Arrange
        given(mockSerivce.retrieveCourses("Matheus"))
                .willReturn(courses);

        // When / Act
        business.deleteCoursesNoRelatedToSpring("Matheus");

        // Then / Assert
        String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";
        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String restCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";

        // Este metodo times() é utilizado para definir a quantidade de vezes que quero rodar essa verificação
        then(mockSerivce)
                .should()
                    .deleteCourse(kotlinCourse);
        then(mockSerivce)
                .should()
                    .deleteCourse(agileCourse);
        // Metodo never é utilizado para dizer que isso nunca vai acontecer
        then(mockSerivce)
                .should(never())
                    .deleteCourse(restCourse);
    }

    @DisplayName("Delete courses not related to spring using mockito " +
            "should call method deleteCourse() and catch by argument captor")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourseWithArgumentCaptor(){
        // Given / Arrange
        /*courses = Arrays.asList(
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );*/
        given(mockSerivce.retrieveCourses("Matheus"))
                .willReturn(courses);
        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // When / Act
        business.deleteCoursesNoRelatedToSpring("Matheus");

        // Then / Assert
        then(mockSerivce)
                .should(times(7))
                .deleteCourse(argumentCaptor.capture());

        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}
