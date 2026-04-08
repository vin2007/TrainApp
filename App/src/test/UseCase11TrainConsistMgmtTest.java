package test;


import java.util.regex.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches("TRN-\\d{4}", "TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainID() {
        assertFalse(Pattern.matches("TRN-\\d{4}", "TRN12A"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches("PET-[A-Z]{2}", "PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCode() {
        assertFalse(Pattern.matches("PET-[A-Z]{2}", "PET-ab"));
    }

    @Test
    void testRegex_EmptyInput() {
        assertFalse(Pattern.matches("TRN-\\d{4}", ""));
    }
}