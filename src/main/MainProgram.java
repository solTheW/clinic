package main;

import java.time.LocalDate;
import java.util.Scanner;



public class MainProgram {
    public static void main(String[] args) throws Exception {
        OfficeWorker patryk = new OfficeWorker("Patryk", "Wlodarski", LocalDate.of(1998,10,18), 101, LocalDate.of(2020,03,01), 1000);
        Nurse beata = new Nurse("Beata","Nowak", LocalDate.of(1970,01,01), 102, LocalDate.of(2002,01,03), 2000, 1001);
        Doctor internista = new Doctor("Adam", "Nowakowski", LocalDate.of(1975,12,03), 103, LocalDate.of(2000,01,01), 3000, 1002, "Internist");
        Doctor pediatra = new Doctor("Artur", "Kregla", LocalDate.of(1980, 04, 05), 104, LocalDate.of(2001,05,07), 4000, 1003, "Pediatrician");
        patryk.addDoctor(internista);
        patryk.addDoctor(pediatra);
        patryk.addNurse(beata);

       
        System.out.println("!!!!HELLO. WELCOM IN CLINIC.01 ALPHA BETA GAMMA PROGRAM.!!!!\n");
        Integer chooseOption=5;
        Scanner input = new Scanner(System.in);      
        do{
            chooseOption=5;
            System.out.println(chooseOption.toString());
            System.out.println("OPTIONS TO CHOOSE:");
            System.out.println("1. REGISTER A VISIT");
            System.out.println("2. GET FULL SALARY");
            System.out.println("3. GET WORK LENGTH");
            System.out.println("4. GET EMPLOYEE");
            System.out.println("5. EXIT");
            System.out.print("CHOOSED OPTION: ");
            chooseOption = Integer.parseInt(input.nextLine());

            if(chooseOption == 1){
                System.out.println("\nHERE");
                if(patryk.registeringAVisit(input) == true){
                    input.nextLine();
                    chooseOption=5;
                }
            }
            else if(chooseOption == 2){
                System.out.println("\nEmployee code: ");
                Integer eCode = input.nextInt();
                Integer fullSalary = patryk.getFullSalary(eCode); 
                if(fullSalary != null){
                    System.out.println("\nSalary: "+fullSalary);
                    chooseOption=5;
                }
            }
            else if(chooseOption == 3){
                    System.out.println("\nEmployee code: ");
                    Integer eCode = input.nextInt();
                    if(patryk.getWorkLength(eCode) != null){
                        chooseOption=5;
                    }
                }
            else if(chooseOption == 4){
                System.out.println("\nEmployee code: ");
                Integer eCode = input.nextInt();
                if(patryk.getEmpolyee(eCode) != null){
                    chooseOption=5;
                }
            }
            else{
                chooseOption=5;
            }
        }while(chooseOption != 5);
        input.close();
    }
}
