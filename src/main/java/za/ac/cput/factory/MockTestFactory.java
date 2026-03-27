/* MockTestFactory.java  
MockTestFactory model class 
Author Angelo Adams (230450431) 
Date: 04 March 2026 */
package za.ac.cput.factory;

//Imports
import za.ac.cput.domain.MockTest;
import za.ac.cput.util.Helper;

import java.time.LocalDate;


//MockTest class;

public class MockTestFactory {
    public static MockTest createMockTest(String testId, LocalDate dateTaken, int score, boolean pass){
        if (Helper.isNullOrEmpty(testId)) {
            return null;
        }

        if (score < 0) {
            return null;
        }
        //build and return MockTest object using builder pattern
        return new MockTest.Builder().setTestId(testId)
                .setDateTaken(dateTaken)
                .setScore(score)
                .setPassed(pass)
                .build();
    }


}
