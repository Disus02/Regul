package ru.sapteh;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите данные о студенте: ");
        ArrayList<Person> arrayList=new ArrayList<>();
        arrayList.add(getPerson(buffer.readLine()));

        //create file, write in file
        File file=new File("C:/test/Student.txt");
        FileWriter fW=new FileWriter(file);
        for (Person person:arrayList) {
            fW.write(person.toString());
            fW.write("\n");
        }
        fW.close();
    }
    // Создание объекта
    public static Person getPerson(String strStudent) throws ParseException {
        String[] strings=strStudent.split(" ");
        String firstName=strings[0];
        String lastName=strings[1];
        String patronymic=strings[2];
        Date date= new SimpleDateFormat("dd.MM.yyyy").parse(strings[3].replaceAll("\\p{Punct}","."));
        int age=getAge(date);
        int quantityDayBirth= quantityDays(getNextBirthday(date));
        String day=String.format("%tA",date);
        Date nextBirthday=getNextBirthday(date);


        return new Person(firstName,lastName,patronymic,date,age,quantityDayBirth,day,nextBirthday);
    }
    //расчёт следующей даты дня рождения
    public static Date getNextBirthday(Date date){
        String[] strings=String.format("%tF",date).split("-");
        int day=Integer.parseInt(strings[2]);
        int month=Integer.parseInt(strings[1]);
        int year=Integer.parseInt(strings[0]);
        Date dateNow=new Date();
        String[] strDateNow=String.format("%tF",dateNow).split("-");
        int dayNow=Integer.parseInt(strDateNow[2]);
        int monthNow=Integer.parseInt(strDateNow[1]);
        int yearNow=Integer.parseInt(strDateNow[0]);
        if (monthNow>=month&& dayNow<=day){
            return new GregorianCalendar(yearNow,month-1,day).getTime();
        }
        if (monthNow<=month&& dayNow>=day){
            return new GregorianCalendar(yearNow,month-1,day).getTime();
        }else
        return new GregorianCalendar(yearNow+1,month-1,day).getTime();
    }
    //количество дней до дня рождения
    public static int quantityDays(Date date){
        LocalDate dateNow=LocalDate.now();
        String[] strDate=String.format("%tF",date).split("-");
        int day=Integer.parseInt(strDate[2]);
        int month=Integer.parseInt(strDate[1]);
        int year=Integer.parseInt(strDate[0]);
        LocalDate dateBirthday=LocalDate.of(year,month,day);
        return (int)ChronoUnit.DAYS.between(dateNow,dateBirthday);
    }
    //количество лет
    public static int getAge(Date date){
        String[] strings=String.format("%tF",date).split("-");
        int day=Integer.parseInt(strings[2]);
        int month=Integer.parseInt(strings[1]);
        int year=Integer.parseInt(strings[0]);
        LocalDate localDate=LocalDate.now();
        LocalDate localDate1=LocalDate.of(year,month,day);
        return (int)ChronoUnit.YEARS.between(localDate1,localDate);
    }
}
