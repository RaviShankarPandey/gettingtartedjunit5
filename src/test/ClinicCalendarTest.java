package test;

import org.junit.jupiter.api.*;
import patientintake.ClinicCalendar;
import patientintake.Doctor;
import patientintake.PatientAppointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {
    private ClinicCalendar calendar;
    @BeforeAll
    static void testClassSetup(){
        System.out.println("Before all...");
    }

    @BeforeEach
    void init(){
        System.out.println("Before each...");
        calendar = new ClinicCalendar(LocalDate.of(2020,4,19));
    }


    @Test
    void allowEntryOfAnAppointment(){
        System.out.println("Entry of appointment...");
        calendar.addAppointment("Ravi","Pandey","avery",
                "4/19/2020 1:00 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        PatientAppointment enteredAppointment = appointments.get(0);
        assertEquals("Ravi",enteredAppointment.getPatientFirstName());
        assertEquals("Pandey",enteredAppointment.getPatientLastName());
        assertSame(Doctor.avery,enteredAppointment.getDoctor());
        assertEquals("4/19/2020 01:00 PM",
                enteredAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));
    }

    @Test
    void returnTrueForHasAppointmentsIfThereAreAppointments(){
        System.out.println("has appointments...");
        calendar.addAppointment("Ravi","Pandey","avery",
                "4/18/2020 1:00 pm");
        assertTrue(calendar.hasAppointment(LocalDate.of(2020,4,18)));
    }

    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments(){
        System.out.println("no appointments...");
        calendar.addAppointment("Ravi","Pandey","avery",
                "4/19/2020 1:00 pm");
        assertFalse(calendar.hasAppointment(LocalDate.of(2020,4,18)));
    }

    @Test
    void returnCurrentDayAppointments(){
        System.out.println("Current day appointments...");
        calendar.addAppointment("Ravi","Pandey","avery",
                "04/19/2020 5:00 PM");
        calendar.addAppointment("Rohit","Pandey","avery",
                "04/19/2020 4:00 PM");
        calendar.addAppointment("Mohit","Pandey","avery",
                "04/20/2020 5:00 PM");
        assertEquals(2,calendar.getTodayAppointments().size());
       // assertIterableEquals(calendar.getTodayAppointments(),calendar.getAppointments());
    }

    @AfterEach
    void tearDownEachTest(){
        System.out.println("After each...");
    }
    @AfterAll
    static void tearDownTestClass(){
        System.out.println("After all...");
    }

}