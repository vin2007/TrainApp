package test;

package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertEquals(72, b.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception e = assertThrows(UseCase14TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", e.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("AC", 60);
        assertEquals("AC", b.type);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        new UseCase14TrainConsistMgmt.PassengerBogie("A", 50);
        new UseCase14TrainConsistMgmt.PassengerBogie("B", 70);
    }
}