package test;

import org.junit.jupiter.api.Test;
import patientintake.DateTimeConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeConverterShould {
    @Test
    void convertTodayStringCorrectly(){
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 1:00 pm",
                LocalDate.of(2020,4,19));
        assertEquals(result,LocalDateTime.of(2020,4,19,13,0));
    }

    @Test
    void convertCorrectPatternToDateTime(){
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("4/19/2020 3:00 pm",
                LocalDate.of(2020,4,19));
        assertEquals(result,LocalDateTime.of(2020,4,19,15,0));
    }

    @Test
    void throwExceptionIfIncorrectPatternProvided(){
        Throwable error = assertThrows(RuntimeException.class,()->
                DateTimeConverter.convertStringToDateTime("4/19/2020 300 pm",
                LocalDate.of(2020,4,19)));
        assertEquals("Unable to create date time from: [4/19/2020 300 pm], " +
                "please enter with format [M/d/yyyy h:mm a], Text '4/19/2020 300 PM' " +
                "could not be parsed at index 13",error.getMessage());
    }

}