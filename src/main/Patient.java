package main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import main.OfficeWorker.mainMedicalProcedures;

public class Patient extends Person{
    /**
     * @serial  mainMedicalProcedures        -   enum that is declared in OfficeWorker.Employee
     * @serial  proceduresToBeDone           -   variable that  determines medical procedures that Patient should be done
     * @serial  boolean proceduresOnlyForPHD -   variable that give info is procedures can be done by doctor
     * */    
    protected mainMedicalProcedures proceduresToBeDone[];  
    protected boolean proceduresOnlyForPHD = false;

    public Patient(String name, String surName, LocalDate dateOfBirth, Integer numberOfProcedures){
        super(name,surName,dateOfBirth);
        proceduresToBeDone = new mainMedicalProcedures[numberOfProcedures];
        setProcedures();
    }
    public Patient(Patient pat){
        super(pat.getName(),pat.getSurName(),pat.getDateOfBirth());
        proceduresToBeDone = Arrays.copyOf(pat.proceduresToBeDone, pat.proceduresToBeDone.length);
    }
    /**
     * This method is asking for medical procedures array. 
     * The length of array is given in constructor of class.
     * Based on choosed option the method will paste the INJECTION or WEIGHT_MEASUREMENT or etc.
     * into array proceduresToBeDone. And that proces will be repeted until the array would be full.
     *@serial Scanner in            -   Scanner for scanning input from terminal
     *@serial Integer intChoosed    -   variable for taking int paste in terminal
     */
    private void setProcedures(){
        Scanner in = new Scanner(System.in);
        Integer intChosed;
        System.out.println(
        "\nPOSSIBLE MEDICAL PROCEDURES:"+ 
        "\n1. INJECTION"+
        "\n2. WEIGHT MEASUREMENT"+
        "\n3. PRESSURE MEASUREMENT"+
        "\n4. BLOOD SAMPLING"+
        "\n5. GENERAL EXAMINATION"+
        "\n6. USG"+
        "\n7. PRESCRIPTION");
        for(int i=0;i<proceduresToBeDone.length;i++){
            System.out.println((i+1)+" procedure: ");
            intChosed = in.nextInt();
            switch(intChosed){
                case 1:{
                    proceduresToBeDone[i]=mainMedicalProcedures.INJECTION;
                    break;}
                case 2:{
                    proceduresToBeDone[i]=mainMedicalProcedures.WEIGHT_MEASUREMENT;
                    break;}
                case 3:{
                    proceduresToBeDone[i]=mainMedicalProcedures.PRESSURE_MEASUREMENT;
                    break;}
                case 4:{
                    proceduresToBeDone[i]=mainMedicalProcedures.BLOOD_SAMPLING;
                    break;}
                case 5:{
                    proceduresToBeDone[i]=mainMedicalProcedures.GENERAL_EXAMINATION;
                    if(!proceduresOnlyForPHD){
                        proceduresOnlyForPHD = true;}
                    break;}
                case 6:{
                    proceduresToBeDone[i]=mainMedicalProcedures.USG;
                    if(!proceduresOnlyForPHD){
                    proceduresOnlyForPHD = true;}
                    break;}
                case 7:{
                    proceduresToBeDone[i]=mainMedicalProcedures.PRESCRIPTION;
                    if(!proceduresOnlyForPHD){
                    proceduresOnlyForPHD = true;}
                    break;}    
            }
        }
        in.close();
    }
    public String toString(){
        StringBuilder str = new StringBuilder(super.toString());
        str.append(" Medical Procedures to do: ");
        for(int i=0;i<proceduresToBeDone.length;i++){
            str.append(" "+proceduresToBeDone[i].toString());
        }
        return str.toString();
    }
}
