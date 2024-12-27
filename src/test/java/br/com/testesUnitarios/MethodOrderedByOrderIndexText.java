package br.com.testesUnitarios;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexText {

    StringBuilder actualValue = new StringBuilder();

    @AfterEach
    void afterEach(){
        System.out.println("The actual value is: " + actualValue);
    }

    @Test
    @Order(0)
    void testA(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
        actualValue.append("1");
    }

    @Test
    @Order(1)
    void testB(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
        actualValue.append("2");
    }

    @Test
    @Order(2)
    void testC(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
        actualValue.append("3");
    }

    @Test
    @Order(3)
    void testD(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
        actualValue.append("4");
    }

    @Test
    @Order(4)
    void testE(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
        actualValue.append("5");
    }
}
