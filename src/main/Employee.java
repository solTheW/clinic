package main;

import java.time.LocalDate;

abstract public class Employee extends Person{

    /**
     * @serial Integer      code                -   employee code 
     * @serial LocalDate    dateOfEmployment    -   date that descibe date of work started employee
     * @serial Integer      salary              -   salary of employment
     */
    private final Integer code;
    private final LocalDate dateOfEmployment;
    private final Integer salary;
    
    public Employee(String newName,String newSurName, LocalDate newDateOfBirth,Integer newCode,LocalDate newDateOfEmployment, Integer newSalary){
        super(newName,newSurName,newDateOfBirth);
        code = newCode;
        dateOfEmployment = newDateOfEmployment;
        salary = newSalary;
    }
   
    public Integer getCode(){
        return code;
    }
    public LocalDate getDateOfEmployment(){
        return dateOfEmployment;
    }
    public Integer getSalary(){
        return salary;
    }
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append( " Code: "+code+
                    " Date Of Employment: "+dateOfEmployment.toString()+
                    " Salary: "+salary+
                    "\n-------------------");
        return str.toString();
    }
}
