package tests.examples;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll
    static void startup() {
        System.out.println("test startup");
    }

    @BeforeEach
    void startBrowser() {
        System.out.println(" - browser has started");
    }

    @AfterEach
    void stopBrowser() {
        System.out.println(" - browser has stopped");
    }

    @Test
    void firstTest() {
        System.out.println(" -- firstTest");
    }

    @Test
    void secondTest() {
        System.out.println(" -- secondTest");
    }

}
