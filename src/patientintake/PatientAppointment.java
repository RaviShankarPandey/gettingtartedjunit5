package patientintake;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.zip.ZipFile;

public class PatientAppointment {
    private String patientFirstName;
    private String patientLastName;
    private LocalDateTime appointmentDateTime;
    private Doctor doctor;

    public PatientAppointment(String patientFirstName, String patientLastName, LocalDateTime localDateTime, Doctor doc) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.appointmentDateTime = localDateTime;
        this.doctor = doc;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public Doctor  getDoctor() {
        return doctor;
    }
}
