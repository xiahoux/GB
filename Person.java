package ru;

public class Person {
    String fullName;
    String post;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Person(String fullName, String post, String email, String phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;



    }

    void printInfo(){
        System.out.println(this);
    }

    public String toString(){
        return
            "ФИО: " + fullName + "\nДолжность: " +
                    post + "\nEmail: " + email +
                    "\nТелефон: " + phoneNumber + "\nЗарплата: " +
                    salary + "$\nВозраст: " + age + "\n";

    }




}
