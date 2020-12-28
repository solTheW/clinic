package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import main.Doctor;
import main.Nurse;
import main.OfficeWorker;

public class TestJunit {
    OfficeWorker patryk = new OfficeWorker("Patryk", "Wlodarski", LocalDate.of(1998,10,18), 101, LocalDate.of(2020,03,01), 1000);
    Nurse beata = new Nurse("Beata","Nowak", LocalDate.of(1970,01,01), 102, LocalDate.of(2002,01,03), 2000, 1001);
    Doctor internista = new Doctor("Adam", "Nowakowski", LocalDate.of(1975,12,03), 103, LocalDate.of(2000,01,01), 3000, 1002, "Internist");
    Doctor pediatra = new Doctor("Artur", "Kregla", LocalDate.of(1980, 04, 05), 104, LocalDate.of(2001,05,07), 4000, 1003, "Pediatrician");
    //Patient pacjent = new Patient("Anna", "Wolanska", LocalDate.of(2004,03,21), 4);

    @Test
    @DisplayName("Test checks if adding doctor is made correctly")
    public void checkOfficeWorkerAddDoctor(){
        assertEquals(true, patryk.addDoctor(internista));
        assertEquals(true, patryk.addDoctor(pediatra));
        assertNotEquals(true, null);
    }
    @Test
    @DisplayName("Test checks if adding nurse is made correctyl")
    public void chechOfficeWorkerAddNurse(){
        assertEquals(true, patryk.addNurse(beata));
        assertEquals(false, null);
    }

    @Test
    @DisplayName("Test checks if search for doctor will return -1")
    public void chechOfficeWorkerSearchingDoctor(){
        assertEquals(-1, patryk.searchForDoctor("a"));
    }
    @Test
    @DisplayName("Test checks if search for doctor will return -1")
    public void checkOfficeWorkerSearchingNurse(){
        assertEquals(-1, patryk.searchForNurse());
    }
    @Test
    @DisplayName("Test checks if getFullSalary will return null")
    public void checkGetFullSalary(){
        assertEquals(null, patryk.getFullSalary(null));
    }
    @Test
    @DisplayName("Test checks if getWorkLength will return null")
    public void checkGetWorkLength(){
        assertEquals(null, patryk.getWorkLength(null));
    }
    @Test
    @DisplayName("Test checks getEmployee")
    public void checkGetEmployee(){
        assertEquals(null, patryk.getEmpolyee(null));
    }

}
