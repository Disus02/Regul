package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date date;
    private int age;
    private int quantityDayBirth;
    private String day;
    private Date nextBirthday;

    public Person(String firstName,String lastName,String patronymic,Date date,int age,
                  int quantityDayBirth,String day,Date nextBirthday){
        this.firstName= firstName;
        this.lastName=lastName;
        this.patronymic=patronymic;
        this.date=date;
        this.age=age;
        this.quantityDayBirth=quantityDayBirth;
        this.day=day;
        this.nextBirthday=nextBirthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantityDayBirth() {
        return quantityDayBirth;
    }

    public String getDay() {
        return day;
    }
    public Date getNextBirthday(){
        return nextBirthday;
    }
    public String toString(){
            return String.format("%s %s %s %s Возраст: %d лет %d дней %s Следующий ДР: %s",
                    getFirstName(),getLastName(),getPatronymic(),
                    new SimpleDateFormat("dd.MM.yyyy").format(getDate()),
                    getAge(),getQuantityDayBirth(),getDay(),
        new SimpleDateFormat("dd.MM.yyyy").format(getNextBirthday()));

    }
}
