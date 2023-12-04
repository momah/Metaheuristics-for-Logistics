package test.java.menus;

import main.java.concrete.Problems.vehiclesVRP.VRPvehiclesProblem;
import main.java.menus.VRPvehiclesView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestVRPvehiclesView {

    @Test
    void testHillClimbingVRP() throws CloneNotSupportedException {
        VRPvehiclesProblem vrpProblem = new VRPvehiclesProblem();
        VRPvehiclesView.hillClimbingVRP(vrpProblem);
        // Add assertions or checks as needed
    }

    @Test
    void testTabuVRP() throws CloneNotSupportedException {
        VRPvehiclesProblem vrpProblem = new VRPvehiclesProblem();
        VRPvehiclesView.tabuVRP(vrpProblem);
        // Add assertions or checks as needed
    }

    @Test
    void testSimulatedAnnealingVRP() throws CloneNotSupportedException {
        VRPvehiclesProblem vrpProblem = new VRPvehiclesProblem();
        VRPvehiclesView.simulatedAnnealingVRP(vrpProblem);
        // Add assertions or checks as needed
    }

    @Test
    void testHillClimbingModifiedVRP() throws CloneNotSupportedException {
        VRPvehiclesProblem vrpProblem = new VRPvehiclesProblem();
        VRPvehiclesView.hillClimbingModifiedVRP(vrpProblem);
        // Add assertions or checks as needed
    }
}
