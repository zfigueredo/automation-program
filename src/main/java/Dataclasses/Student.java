package Dataclasses;

import java.util.List;

public class Student {

    private String name;
    private String lastName;
    private String email;
    private String country;
    private String age;
    private String date;

   List<String> courses;

    public Student(String name, String country, String date) {
        this.name = name;
        this.country = country;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public List<String> getCourses() {
        return courses;
    }
    public void addCourse(String courses){
        this.courses.add(courses);
    }


}
