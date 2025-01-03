package br.com.testesUnitarios.service;

import br.com.testesUnitarios.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup(){
        this.person = new Person(
                "Keith",
                "Moon",
                "kmoon@gmail.com",
                "Wembley",
                "Male"
        );
    }

    @DisplayName("When Create a new Person with sucess should Return a Person Class")
    @Test
    void testCreatePerson_WhenSucess_ShouldReturnPersonObject(){
        IPersonService personService = new PersonService();

        Person actualPerson = personService.createPerson(person);

        assertNotNull(actualPerson, () -> "Create person should not have null Person");
    }

    @DisplayName("When Create a new Person with sucess should atributes Return with Person Object()")
    @Test
    void testAtributes_WhenAtributeIsDifferent_ShouldReturnErrorToAtributeIsDifferent(){
        IPersonService personService = new PersonService();

        Person actualPerson = personService.createPerson(person);

        assertNotNull(person.getId(), () -> "Id is incorrect");
        assertEquals(person.getFirstName(), actualPerson.getFirstName(),  () -> "Create person should not have null name");
        assertEquals(person.getAddress(), actualPerson.getAddress(),  () -> "Create person should not have null address");
        assertEquals(person.getLastName(), actualPerson.getLastName(),  () -> "Create person should not have null last name");
        assertEquals(person.getEmail(), actualPerson.getEmail(),  () -> "Create person should not have null email");
        assertEquals(person.getGender(), actualPerson.getGender(),  () -> "Create person should not have null gender");
    }

    @DisplayName("When Create a new Person with null email should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException(){
        IPersonService personService = new PersonService();
        String expectedMessage = "Email can´t be null";
        person.setEmail(null);
        IllegalArgumentException actual = assertThrows(
                IllegalArgumentException.class,
                () -> personService.createPerson(person),
                () -> "Empty email should have cause an IllegalArgumentException"
        );

        assertEquals(
                expectedMessage,
                actual.getMessage(),
                () -> "The throw message should be 'Email can´t be null'");
    }


}
