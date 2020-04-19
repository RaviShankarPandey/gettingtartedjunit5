package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import patientintake.DateTimeConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("DateTimeConverter should")
class DateTimeConverterShould {
    @Nested //can be used to group similar tests
    @DisplayName("convert string with 'today' keyword") //for better reporting
    class TodayTests{
        @Test
        @DisplayName("correctly")
        void convertTodayStringCorrectly(){
            LocalDate today = LocalDate.of(2020, 4, 19);
            LocalDateTime result = DateTimeConverter.convertStringToDateTime("today 1:00 pm",
                    today);
            assertEquals(result,LocalDateTime.of(2020,4,19,13,0),
                    () -> "Failed to convert 'today' string to expected date time, " +
                            "today passed was: "+today);//evaluates only if there is a failure
        }
        @Test
        @DisplayName("regardless of case")
        void convertTodayStringCorrectlyCaseInsensitive(){
            LocalDate today = LocalDate.of(2020, 4, 19);
            LocalDateTime result = DateTimeConverter.convertStringToDateTime("ToDay 1:00 pm",
                    today);
            assertEquals(result,LocalDateTime.of(2020,4,19,13,0),
                    () -> "Failed to convert 'today' string to expected date time, " +
                            "today passed was: "+today);//evaluates only if there is a failure
        }
    }
    @Test
    @DisplayName("convert expected date time pattern in string correctly")
    void convertCorrectPatternToDateTime(){
        LocalDateTime result = DateTimeConverter.convertStringToDateTime("4/19/2020 3:00 pm",
                LocalDate.of(2020,4,19));
        assertEquals(result,LocalDateTime.of(2020,4,19,15,0));
    }

    @Test
    @DisplayName("throw exception if date time pattern is incorrect")
    void throwExceptionIfIncorrectPatternProvided(){
        Throwable error = assertThrows(RuntimeException.class,()->
                DateTimeConverter.convertStringToDateTime("4/19/2020 300 pm",
                LocalDate.of(2020,4,19)));
        assertEquals("Unable to create date time from: [4/19/2020 300 pm], " +
                "please enter with format [M/d/yyyy h:mm a], Text '4/19/2020 300 PM' " +
                "could not be parsed at index 13",error.getMessage());
    }

}