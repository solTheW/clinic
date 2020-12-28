package main;

import java.util.ArrayList;
import java.util.logging.*;
import java.io.IOException;
import java.time.LocalDate;

abstract public class MedicalWorker extends Employee{
    /**
     * @serial Integer      permissionNumber        -   number of the medical license number
     * @serial ArrayList    listOfPatientToBeCured  -   list of patient that each one of medical worker have to cure
     * @serial Logger       logPrint                -   logger used to print info to terminal
     * @serial Logger       logFile                 -   logger used to paste info to file
     * @serial FileHandler  fh                      -   handler to file which is used in logFile. Name of file is given in classconstructor
    */
    private final Integer permissionNumber;
    protected ArrayList<Patient> listOfPatientToBeCured;

    private static final Logger logPrint = Logger.getLogger(MedicalWorker.class.getName());
    private static Logger logFile = Logger.getLogger("LOG");
    private static FileHandler fh;
  
    public MedicalWorker(String name,String surName, LocalDate dateOfBirth,Integer newCode,LocalDate newDateOfEmployment, Integer newSalary,Integer newPermissionNumber){
        super(name,surName,dateOfBirth,newCode,newDateOfEmployment,newSalary);
        permissionNumber = newPermissionNumber;
        listOfPatientToBeCured = new ArrayList<Patient>();
        try{
        fh = new FileHandler("log.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
        logFile.addHandler(fh);
    }
    /**
     * This method is adding a Patient pat to an ArrayList listOfPatientToBeCured.
     * It also send log to file and to terminal that the patient has been added to list.
     * @param pat Patient -   Patient that we will be adding to list     
     * @return true       -   if the @param pat is not null
     * @return false      -   if the @param pat is null
     */
    protected boolean addPatient(Patient pat){
        if(pat == null) return false;
        else{
            listOfPatientToBeCured.add(pat);
            logFile.severe("Patient "+pat.toString()+" has been added to list List Of Patient to be cured. ");
            logPrint.info("Patient "+pat.toString()+" has been added to list List Of Patient to be cured. ");
            return true;
        }
    }
    protected Integer getPermissionNumber(){
        return permissionNumber;
    }
    /**
     * This method is deleting the patient on place 0 in list. 
     * It also send log to file and to terminal that we deleted patient form listToBeCured
     * @serial pat Patient  -   Patient that has been in list to be cured on begining.
     */
    protected void curePatient(){
        Patient pat = new Patient(listOfPatientToBeCured.remove(0));
        logFile.info("Patient "+pat.toString()+" has been cured by "+getName()+" "+getSurName()+" This patient is deleted from list Patien to be cured. ");
        logPrint.info("Patient "+pat.toString()+" has been cured by "+getName()+" "+getSurName()+" This patient is deleted from list Patien to be cured");
    }
}
