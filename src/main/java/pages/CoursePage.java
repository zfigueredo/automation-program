package pages;

import Dataclasses.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoursePage extends BasePage{

    By inputName_Locator = By.id("name");
    By inputLastName_Locator = By.id("lastName");
    By inputEmail_Locator = By.id("email");
    By selectCountry_Locator = By.id("country");
    By inputAge_Locator = By.id("age");
    By selectedDateCalendar_Locator = By.id("selectedDate");
    By checkboxSelenium_Locator = By.id("selenium");
    By checkboxProgramming_Locator = By.id("programming");
    By checkboxJava_Locator = By.id("java");
    By checkboxAPITesting_Locator = By.id("apiTesting");

    By checkboxCoursesList_Locator = By.cssSelector("input[type='checkbox']");

    By addCourseBtn_Locator = By.xpath("//button[normalize-space()='Adicionar Curso']");

    By tableCellsList_Locator = By.xpath("//table//tr//td");

    By tableResult_Locator = By.id("userTable");

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name){
        type(inputName_Locator,name);
    }

    public void typeLastName(String lastName){
        type(inputLastName_Locator,lastName);
    }

    public void typeEmail(String email){
        type(inputEmail_Locator,email);
    }

    public void selectCountry(String country){
        Select select = new Select(findElement(selectCountry_Locator));
        select.selectByVisibleText(country);
    }

    public void typeDate(String date){
        type(selectedDateCalendar_Locator,date);
    }

    public void selectJavaCourse(){
        WebElement checkboxJava = findElement(checkboxJava_Locator);
        scrollIntoViewAndClick(checkboxJava);
    }

    public void selectProgrammingCourse(){
        WebElement checkboxProgramming = findElement(checkboxProgramming_Locator);
        scrollIntoViewAndClick(checkboxProgramming);
    }
    public void selectSeleniumCourse(){
        WebElement checkboxSelenium = findElement(checkboxSelenium_Locator);
        scrollIntoViewAndClick(checkboxSelenium);
    }
    public void selectAPITestingCourse(){
        WebElement checkboxAPITesting = findElement(checkboxAPITesting_Locator);
        scrollIntoViewAndClick(checkboxAPITesting);
    }
    public void clickOnAddCourse(){
        scrollIntoViewAndClick(addCourseBtn_Locator);
    }

    public boolean verifyTextIsPresentInTable(String element){
        List<WebElement> cellsList = findElements(tableCellsList_Locator);
        List<String> cellsText = new ArrayList<>();

        for (WebElement cell : cellsList) {
            cellsText.add(cell.getText());
        }

        boolean isTextPresent = cellsText.contains(element);
        System.out.println("isText: " + element +"present: "+isTextPresent);

        return isTextPresent;

    }


    public void selectRandomCourses(int quantity){
        List<WebElement> coursesList = findElements(checkboxCoursesList_Locator);
        Collections.shuffle(coursesList);
        for (int i = 0; i < Math.min(quantity,coursesList.size()); i++) {
            scrollIntoViewAndClick(coursesList.get(i));
        }
    }

    public void addingSelectedCoursesToStudent(Student student){
        List<WebElement> coursesList = findElements(checkboxCoursesList_Locator);
        for (WebElement course : coursesList){
            if(course.isSelected()){
                String courseName = course.getDomAttribute("value");
                System.out.println("course name: "+courseName);
                if(!courseName.isEmpty())
                    student.addCourse(courseName);
            }
        }
    }


    public boolean isCoursePresentForUser(Student student) {
        WebElement table = findElement(tableResult_Locator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() >= 4) {

                String nameCell = cells.get(0).getText().trim();
                String studentName = student.getName();
                boolean isNamePresent = nameCell.equalsIgnoreCase(studentName);
                System.out.println("Student name:" + studentName + "| name in table:"+nameCell);
                System.out.println("is student Name Present:"+isNamePresent);

                String studentCountry = student.getCountry();
                String countryCell = cells.get(1).getText().trim();
                boolean isCountryPresent = countryCell.equalsIgnoreCase(studentCountry);
                System.out.println("Student country:" + studentCountry + "| country in table:"+countryCell);
                System.out.println("is student Country Present:"+isCountryPresent);

                String studentDate = student.getDate();
                String dateCell = cells.get(2).getText().trim();
                boolean isDatePresent = Utility.compareDates(student.getDate(), "MM/dd/yyyy",
                        cells.get(2).getText().trim(), "yyyy-MM-dd");

                System.out.println("Student date:" + studentDate + "| date in table:"+dateCell);
                System.out.println("is student Date present:"+isDatePresent);


                String courseCell = cells.get(3).getText().trim();
                List<String> studentCourses = student.getCourses();
                boolean areAllCoursesPresent = studentCourses.stream()
                        .allMatch(course -> courseCell.contains(course));

                System.out.println("Student courses:" + studentCourses + "| course in table:"+courseCell);
                System.out.println("is student Course present:"+areAllCoursesPresent);

                if (isNamePresent && isCountryPresent && isDatePresent && areAllCoursesPresent) {
                    return true;
                }
            }
        }
        return false;
    }







}



