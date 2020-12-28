package main;

import java.time.LocalDate;

public class Doctor extends MedicalWorker{
    /**
     * @serial StringBuilder doctorType -   it give us info about doctor. If he is Pediatrician doctorType = Pediatrician
     */
    private final StringBuilder doctorType;
    public Doctor(String name,String surName, LocalDate dateOfBirth,Integer newCode,LocalDate newDateOfEmployment, Integer newSalary,Integer newPermissionNumber,String type){
        super(name,surName,dateOfBirth,newCode,newDateOfEmployment,newSalary,newPermissionNumber);
        doctorType = new StringBuilder(type);
    }
    public String getDoctorType(){
        return doctorType.toString();
    }
}
