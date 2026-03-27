/* VehicleFactoryTest.java
   Test class for VehicleFactory
   Author: Redah Gamieldien (222641681)
   Date: 26 March 2026
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Vehicle;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


// Enables tests to run in order using @Order annotations
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class VehicleFactoryTest {

    // Test 1: Create a valid vehicle with all fields
    @Test
    @Order(1)
    public void testCreateVehicle() {
        Vehicle vehicle = VehicleFactory.createVehicle(
                "TC001",             // vehicleID
                "Toyota Corolla",   // model
                "CAA 656-841",       // regNumber
                "Manual",           // transmissionType
                true                // isAvailable
        );
        assertNotNull(vehicle);  // Verify vehicle was created
    }

    // Test 2: Create a vehicle with a null vehicle ID
    @Test
    @Order(2)
    public void testCreateVehicleWithEmptyVehicleID() {
        Vehicle vehicle = VehicleFactory.createVehicle(
                "",               // vehicleID (Empty)
                "Toyota Corolla",   // model
                "CAA 656-841",       // regNumber
                "Manual",           // transmissionType
                true                // isAvailable
        );
        assertNull(vehicle);  // Verify vehicle was NOT created
    }

    // Test 3: Create a vehicle with an empty transmission type
    @Test
    @Order(3)
    public void testCreateVehicleWithEmptyTransmissionType() {
        Vehicle vehicle = VehicleFactory.createVehicle(
                "TC001",             // vehicleID
                "Toyota Corolla",   // model
                "CAA 656-841",       // regNumber
                "",                 // transmissionType (empty)
                true                // isAvailable
        );
        assertNull(vehicle);  // Verify vehicle was NOT created
    }


}
