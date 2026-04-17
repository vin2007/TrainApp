package test;

package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");
        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmt.GoodsBogie b1 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        b1.assignCargo("Petroleum");

        UseCase15TrainConsistMgmt.GoodsBogie b2 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");
        b2.assignCargo("Petroleum");

        assertEquals("Petroleum", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgmt.GoodsBogie b =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");
        b.assignCargo("Coal");
        assertEquals("Coal", b.cargo);
    }
}