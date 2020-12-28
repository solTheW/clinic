package main;

import java.time.LocalDate;

abstract public class Person {

    /**
     * @serial  String      name        - Patient name
     * @serial  String      surName     - Patient surname
     * @serial  LocalDate   dateofBirth - LocalDate is class that determines YEAR-MONTH-DAY birth day.
     */
    private final String name;
    private final String surName;
    private final LocalDate dateOfBirth;

    public Person(String newName, String newSurName, LocalDate newDateOfBirth){
        name = newName;
        surName = newSurName;
        dateOfBirth = newDateOfBirth;
    }
    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("\nName: "+getName()+
                    " Surname: "+getSurName()+
                    " Date of birth:YYYY-MM-DD "+getDateOfBirth().toString());
        return str.toString();
    }
}
