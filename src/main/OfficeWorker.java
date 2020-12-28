package main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;



public class OfficeWorker extends Employee{
    /**
     * This class describes and gives every OfficceWorker possible methods and variables
     *@serial   enum        mainMedicalProcedures   -   describes mediacal procedures that is posiible to make on patient.
                                                        0-3 NURSE AND DOCTOR
                                                        4-6 ONLY DOCTOR
     *@serial   ArrayList   nursesList              -   list of nureses in clinic
     *@serial   ArrayList   doctorsList             -   list of doctors in clinic               
     */
    protected enum mainMedicalProcedures{
        INJECTION,
        WEIGHT_MEASUREMENT,
        PRESSURE_MEASUREMENT,
        BLOOD_SAMPLING,

        GENERAL_EXAMINATION,
        USG,
        PRESCRIPTION
    };
    
    private ArrayList<Nurse> nursesList;
    private ArrayList<Doctor> doctorsList;

    public OfficeWorker(String name,String surName, LocalDate dateOfBirth,Integer newCode,LocalDate newDateOfEmployment, Integer newSalary){
        super(name,surName,dateOfBirth,newCode,newDateOfEmployment,newSalary);
        nursesList= new ArrayList<Nurse>();
        doctorsList= new ArrayList<Doctor>();
    }
    /**
     * This method is adding doctor to doctorsList.
     * @param   Doctor    med     -   Doctor that should be added to clinic
     * @return  boolean true    -   if Doctor med is not null 
     * @return  boolean false   -   if Doctor med is null
     */
 
    public boolean addDoctor(Doctor med){
        if(med == null) return false;
        else{
            doctorsList.add(med);
            return true;
        }
    }
    /**
     * This method is adding nurse to nursesList.
     * @param   Nurse  nrs      -   Nurse that should be added to clinic
     * @return  boolean true    -   if Nurse nrs is not null 
     * @return  boolean false   -   if Nurse nrs is null
     */
    public boolean addNurse(Nurse nrs){
        if(nrs == null) return false;
        else{
            nursesList.add(nrs);
            return true;
        }
    }
    /**
     * This method is used to take Patient data and create newPatient with this data.
     * @serial String           name            - name of patient   
     * @serial String           surName         - surname of patient
     * @serial Integer          yearBirth       - year of patient birth
     * @serial Integer          monthBirth      - month of patient birth
     * @serial Integer          dayBirth        - day of patient birth
     * @serial Integer          nmbOfProcedures - number of procedures that will be done on patient
     * @serial Scanner          in              - scanner to terminal
     * @return Patient          newPatient      - patient that will be paste to medical workers          
     */    
    private Patient readPatient(Scanner in){
        String name;
        String  surName;
        Integer yearBirth;
        Integer monthBirth;
        Integer dayBirth;
        Integer nmbOfProcedures;
        Patient newPatient = null;
            
        System.out.println("Patient name: ");
        name= in.nextLine().toString();
            if(name.isEmpty() || name.isBlank()){
                System.out.println("\nWrong name");
                return null;
            }

        System.out.println("Patient surname: ");
        surName =in.nextLine().toString();
            if(surName.isEmpty() || surName.toString().isBlank()){
                System.out.println("\nWrong surname");
                return null;
            }

        System.out.println("Patient birth year: ");
        yearBirth = in.nextInt();
            if(yearBirth > LocalDate.now().getYear() || yearBirth <= 0){
                System.out.println("\nWrong birth year");
                return null;
            }

        System.out.println("Patient birth month: ");
        monthBirth = in.nextInt();
            if(monthBirth <1){
                System.out.println("\nWrong birth month");
                return null;
            }
       
        System.out.println("Patient birth day: ");
        dayBirth = in.nextInt();
            if(dayBirth <1){
                System.out.println("\nWrong birth day");
                return null;
            }
        
        System.out.println("Number of procedures: ");
        nmbOfProcedures = in.nextInt();
            if(nmbOfProcedures <0){
                System.out.println("\nWrong number of procedures");
                return null;
            }
        newPatient = new Patient(name.toString(),surName.toString(),LocalDate.of(yearBirth,monthBirth,dayBirth),nmbOfProcedures);
        return newPatient;
    }
    /**
     * This method is search for doctor with the minimal number of patient to be cured.
     * @param   String   doc                    -   argument that says if we will be looking Pediatrician or Internist
     * @return  Integer indexDoctorWithMinPat   -   index of doctor searched in doctorsList
     * @return                              -1  -   if i can't find doctor
     */
    public Integer searchForDoctor(String doc){
        if(doctorsList.isEmpty()) return -1;
        if(doc == "Internist"){
            //We are looking for Internist
            for(int i = 0; i < doctorsList.size() ; i++){
                if(doctorsList.get(i).getDoctorType() == "Internist"){
                    Integer helpVar=i;
                    Integer indexDoctorWithMinPat=helpVar;
                    while(helpVar < doctorsList.size()){
                        if(doctorsList.get(helpVar).listOfPatientToBeCured.size() < doctorsList.get(indexDoctorWithMinPat).listOfPatientToBeCured.size()){
                            indexDoctorWithMinPat = helpVar;
                        }
                        helpVar++;
                    }
                    return indexDoctorWithMinPat;
                }
            }
            return -1;
        }
        else{
            //We are looking for Pediatrician
            for(int i = 0; i < doctorsList.size() ; i++){
                if(doctorsList.get(i).getDoctorType() == "Pediatrician"){
                    Integer helpVar=i;
                    Integer indexDoctorWithMinPat=helpVar;
                    while(helpVar < doctorsList.size()){
                        if(doctorsList.get(helpVar).listOfPatientToBeCured.size() < doctorsList.get(indexDoctorWithMinPat).listOfPatientToBeCured.size()){
                            indexDoctorWithMinPat = helpVar;
                        }
                        helpVar++;
                    }
                    return indexDoctorWithMinPat;
                }
            }
            return -1;

        }
    }
      /**
     * This method is search for nurse with the minimal number of patient to be cured.
     * @return  Integer indexNurseWithMinPat   -   index of nurse searched in nursesList
     * @return                            -1   -   if i can't find nurse
     */
    public Integer searchForNurse(){
        if(nursesList.isEmpty()) return -1;
        Integer i=0;
        Integer indexNurseWithMinPat=0;
        while( i < nursesList.size()){
            if(nursesList.get(i).listOfPatientToBeCured.size() < nursesList.get(indexNurseWithMinPat).listOfPatientToBeCured.size()){
                indexNurseWithMinPat=i;
            }
            i++;
        }
        return indexNurseWithMinPat;
    }
    /**
     * This method is used for registering a visit. It use another methods to get patient data and to paste patient to nurse or doctors.
     * @serial Patient pat  -   patient that we paste to medical worker (nurse or doctor)
     * @return         true -   if register is ok
     * @return         false-   if register is not ok
     */
    public boolean registeringAVisit(Scanner in){
        Patient pat;
        pat = readPatient(in);
        if(pat == null){
            return false;
        }
        else{
            if(pat.proceduresOnlyForPHD){
                if(LocalDate.now().getYear() - pat.getDateOfBirth().getYear() > 18){
                    //We will be adding to Internist
                    Integer docSearch = searchForDoctor("Internist");
                    if(docSearch == -1){
                        return false;
                    }else{
                    doctorsList.get(docSearch).addPatient(pat);
                        return true;
                    }
                }
                else{
                    //We will be adding to Pediatrician
                    Integer docSearch = searchForDoctor("Pediatrician");
                    if(docSearch == -1){
                        return false;
                    }else{
                    doctorsList.get(docSearch).addPatient(pat);
                        return true;
                    }
                }
            }else{
                Integer nurseSearch = searchForNurse();
                if(nurseSearch == -1){
                    return false;
                }
                nursesList.get(nurseSearch).addPatient(pat);
                return true;
            }
        }
    }
    /**
     * This method calculate full salary by multiplication salary and number of full months in work
     * @param   Integer code        -   code of empolyye. By this number we search employee
     * @return  Integer fullSalary  -   salary of patient that we calculate
     * @return          null        -   if code is wrong or if i can't find employee
     */
    public Integer getFullSalary(Integer code){
        if(code == null || code <= 0) return null;
        else{
            Employee emp = getEmpolyee(code);
            if(emp == null){
                System.out.println("\nEmployee not found");
                return null;
            }
            Integer fullSalary = emp.getSalary() * emp.getDateOfEmployment().getMonthValue();
            return fullSalary;
        }
    }
    /**
     * This method is used to search employee by code and returns length of work
     * @param   Integer code    -   code of employee. By this number we search employee      
     * @return  Float   value   -   the length of work
     * @return          null    -   if code is wrong or if i can't find employee
     */
    public Float getWorkLength(Integer code){
        if(code == null || code <= 0) return null;
        else{
            Employee emp = getEmpolyee(code);
            if(emp == null){
                System.out.println("\nEmployee not found");
                return null;
            }
            Double value = ChronoUnit.DAYS.between(emp.getDateOfEmployment(),LocalDate.now())/365.0;
            value+=emp.getDateOfEmployment().getYear();
            return Float.parseFloat(value.toString());
        }
    }
    /**
     * This method search List by code and returns founded Employee
     * @param   Integer     code    -   code of employee, By this number we search employee
     * @return  Employee            -   if we found Employee we return it
     * @return  null                -   if the @param code is null or we will not found Employee 
     */
    public Employee getEmpolyee(Integer code){
        if(code == null || code <=0){
            System.out.println("\nEmployee not found");
            return null;   
        }else{
                for(int i=0 ;i < nursesList.size(); i++){
                    if(nursesList.get(i).getCode() == code)
                        return nursesList.get(i);
                }
                for(int i = 0; i < doctorsList.size(); i++ ){
                    if(doctorsList.get(i).getCode() == code)
                        return doctorsList.get(i);
                }
            System.out.println("\nEmployee not found");
            return null;
        }
    }
}
