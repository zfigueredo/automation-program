package tests;

import Dataclasses.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CoursePage;
import pages.HomePage;
import pages.QSCreditCardsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(CourseTest.class);

    private final String studentCSVFile = "/files/students.csv";

    HomePage homePage;
    CoursePage coursePage;

    @BeforeEach
    void initPageObject() {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.clickOnCoursesLink();
    }

    @Test
    void test() {
        coursePage.typeName("Ana");
        coursePage.typeDate("04/30/2025");
        coursePage.selectAPITestingCourse();
        coursePage.selectJavaCourse();
        coursePage.clickOnAddCourse();
        coursePage.verifyTextIsPresentInTable("Ana");
    }

    @ParameterizedTest
    @CsvFileSource(resources = studentCSVFile, numLinesToSkip = 1)
    void verifyAdding_StudentCourses(String name, String country, String date, int courses) {

        Student student = new Student(name, country, date);

        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectRandomCourses(courses);
        coursePage.addingSelectedCoursesToStudent(student);

        coursePage.clickOnAddCourse();

        Assertions.assertTrue(coursePage.isCoursePresentForUser(student),"student not added to the table correctly");

    }

    @Test
    void verifyAdding_Single_StudentCourses() {

        Student student = new Student("Ana","Colombia","05/02/2025");

        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectRandomCourses(2);
        coursePage.addingSelectedCoursesToStudent(student);

        coursePage.clickOnAddCourse();

        Assertions.assertTrue(coursePage.isCoursePresentForUser(student),"student not added to the table correctly");

    }

}
