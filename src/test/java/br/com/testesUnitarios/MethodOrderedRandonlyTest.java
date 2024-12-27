package br.com.testesUnitarios;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandonlyTest {

    @Test
    void testA(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
    }

    @Test
    void testB(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
    }

    @Test
    void testC(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
    }

    @Test
    void testD(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
    }

    @Test
    void testE(TestInfo testInfo){
        System.out.println("Running " + testInfo.getTestMethod().orElseThrow().getName());
    }
}