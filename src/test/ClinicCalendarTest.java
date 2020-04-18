package test;

import org.junit.jupiter.api.Test;
import patientintake.ClinicCalendar;
import patientintake.Doctor;
import patientintake.PatientAppointment;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {
    @Test
    void allowEntryOfAnAppointment(){
        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("Ravi","Pandey","avery",
                "4/19/2020 1:00 pm");
        List<PatientAppointment> appointments = calendar.getAppointments();
        assertNotNull(appointments);
        assertEquals(1,appointments.size());
        PatientAppointment enteredAppointment = appointments.get(0);
        assertEquals("Ravi",enteredAppointment.getPatientFirstName());
        assertEquals("Pandey",enteredAppointment.getPatientLastName());
        assertEquals(Doctor.avery,enteredAppointment.getDoctor());
        assertEquals("4/19/2020 01:00 PM",
                enteredAppointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a")));


    }

}