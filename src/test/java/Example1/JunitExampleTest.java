package Example1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitExampleTest {

        @BeforeAll
        static void beforeAll(){
            System.out.println("This is a Before All tes");
        }

    @BeforeEach
    void setUp() {
        System.out.println("This is the BeforeEach");
    }
    @AfterEach
    void tearDown() {
        System.out.println("This is the AfterEach");
    }

    @Order(1)
    @DisplayName("This is the Login Test")
    @Test
    void loginn() {
        System.out.println("This is the Login test");
    }

    @Order(2)
    @DisplayName("ABOUT_001_This is the Test to verify the About Page is correct")
    @Test
    void verifyAboutPage() {
        System.out.println("This is the Verify About test");
    }

    //@Disabled()//Esta linea es para deshabilitar tests que no queremos que se ejecuten.
    @Order(3)
    @DisplayName("This is the Logout Test")
    @Test
    void logoutt() {
        System.out.println("This is the Logout test");
    }


    @Test
    void login() {
        System.out.println("This is the Login test");
    }
    @Test
    void verifyAbout() {
        System.out.println("This is the Verify About test");
    }
    @Test
    void logout() {
        System.out.println("This is the Logout test");
    }

    @AfterAll
        static void AfterAll(){
            System.out.println("This is the After All");
        }

}
