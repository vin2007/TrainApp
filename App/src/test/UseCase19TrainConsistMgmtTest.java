package test;

package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase19TrainConsistMgmtTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UseCase19TrainConsistMgmt.binarySearch(arr,"BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(UseCase19TrainConsistMgmt.binarySearch(arr,"BG999"));
    }
}
