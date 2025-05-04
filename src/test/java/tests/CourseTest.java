package tests;

import Dataclasses.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CoursePage;
import pages.HomePage;
import pages.QSCreditCardsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest extends BaseTest{

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
