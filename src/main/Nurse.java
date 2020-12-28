package main;

import java.time.LocalDate;

public class Nurse extends MedicalWorker {

    public Nurse(String name,String surName, LocalDate dateOfBirth,Integer newCode,LocalDate newDateOfEmployment, Integer newSalary,Integer newPermissionNumber){
        super(name,surName,dateOfBirth,newCode,newDateOfEmployment,newSalary,newPermissionNumber);
    }
    
}
