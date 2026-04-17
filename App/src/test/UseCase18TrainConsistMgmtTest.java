package test;

package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase18TrainConsistMgmtTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UseCase18TrainConsistMgmt.linearSearch(arr,"BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(UseCase18TrainConsistMgmt.linearSearch(arr,"BG999"));
    }
}