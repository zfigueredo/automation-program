package utils;

import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utility {

    public static void printElementInfo(String name, WebElement element) {
        String marker = "------------------------------";
        System.out.println(marker);
        System.out.println("Element meta-data: " + name);
        System.out.println(marker);
        System.out.println("WebElement object:: " + element);
        System.out.println("Outer HTML:: " + element.getAttribute("outerHTML"));
        System.out.println("Inner HTML:: " + element.getAttribute("innerHTML"));
        System.out.println("Text:: " + element.getText());
        System.out.println("Value::" + element.getAttribute("value"));
        System.out.println("Tag:: " + element.getTagName());
        System.out.println("Displayed?:: " + element.isDisplayed());
        System.out.println("Selected?:: " + element.isSelected());
        System.out.println("Enabled?:: " + element.isEnabled());
        System.out.println(marker);
    }
    public static boolean compareDates(String date1, String format1, String date2, String format2) {

        try {
            // "dd/MM/yyyy"
            DateTimeFormatter date1Formatter = DateTimeFormatter.ofPattern(format1);
            LocalDate date1LocalDate = LocalDate.parse(date1, date1Formatter);

            // "yyyy-MM-dd"
            DateTimeFormatter date2Formatter = DateTimeFormatter.ofPattern(format2);
            LocalDate date2LocalDate = LocalDate.parse(date2, date2Formatter);

            // Comparing dates
            return date1LocalDate.equals(date2LocalDate);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing dates: " + e.getMessage());
            return false;
        }

    }


}
