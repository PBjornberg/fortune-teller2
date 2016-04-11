package se.nackademin;

import static org.hamcrest.Matchers.lessThan;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;

public class MagicNumberTest {
    MagicNumbers magicNumbers;

    @Before
    public void setUp() {
        magicNumbers = new MagicNumbers();
        magicNumbers.setAge(16);
        magicNumbers.setHeight(165);
        magicNumbers.setIncome(11000);
        magicNumbers.setLocation("Hagfors");
        magicNumbers.setName("Sture Hagfors");
    }

    @Test
    public void testA() {
        assertEquals("A is not calculated correctly", 4, magicNumbers.calculateA());
    }
   
     /**
     * This is a test that will confirm the fix for issue #39.
     * Acceptance testing showed that magicNumbers.calculateA() could return values outside its permitted boundaries.
     * For performance reasons, we only write a unit test.
     * (the defect had nothing to do with the integration between classes)
     */
    @Test
    public void testAforNefativeAge() {
        // Override previously set age with a negative value
        magicNumbers.setAge(-5);
        assertEquals("A is not calculated correctly", 7, magicNumbers.calculateA());
    }
    
    /**
     * Unsolved issue!!!
     */
    @Test
    public void testAforTwoNamesAge8() {
        // Override previously set age with a negative value
        magicNumbers.setAge(8);
        assertThat(magicNumbers.calculateA(),lessThan(10));
    }
    
    @Test
    public void testB() {
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }
    
    /**
     * This is a test that will confirm the fix for issue #37.
     * Acceptance testing showed that magicNumbers.calculateB() could return values outside its permitted boundaries.
     * For performance reasons, we only write a unit test.
     * (the defect had nothing to do with the integration between classes)
     */
    @Test
    public void testBforNegativeIncome() {
        // Override previously set income with a negative value
        magicNumbers.setIncome(-11000);
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }

    @Test
    public void testC() {
        assertEquals("C is not calculated correctly", 2, magicNumbers.calculateC());
    }

     /**
     * This is a test that will confirm the fix for issue #38.
     * Acceptance testing showed that magicNumbers.calculateC() could return values outside its permitted values.
     * For performance reasons, we only write a unit test.
     * (the defect had nothing to do with the integration between classes)
     */
    @Test
    public void testCforZeroHeight() {
        // Override previously height with zero value    
        magicNumbers.setHeight(0);
        assertEquals("C is not calculated correctly", 3, magicNumbers.calculateC());
    }
    
     /**
     * This is a test that will confirm the fix for issue #40.
     * Acceptance testing showed that magicNumbers.calculateC() could return values outside its permitted values.
     * For performance reasons, we only write a unit test.
     * (the defect had nothing to do with the integration between classes)
     */
    @Test
    public void testCforNegativeHeight() {
        // Override previously height with negative value        
        magicNumbers.setHeight(-183);
        assertEquals("C is not calculated correctly", 4, magicNumbers.calculateC());
    }
    
    @Test
    public void testD() {
        assertEquals("D is not calculated correctly", 6, magicNumbers.calculateD());
    }

     /**
     * This is a test that will confirm the fix for issue #41.
     * Acceptance testing showed that magicNumbers.calculateD() could return values outside its permitted values.
     * For performance reasons, we only write a unit test.
     * (the defect had nothing to do with the integration between classes)
     */
    @Test
    public void testDwithZeroIncome() {
        // Override previously income with zero value        
        magicNumbers.setIncome(0);        
        assertEquals("D is not calculated correctly", 0, magicNumbers.calculateD());
    }
    
    @Test
    public void testDWithAGreaterThan5() {
        magicNumbers.setAge(18);
        assertEquals("D is not calculated correctly", 9, magicNumbers.calculateD());
    }

    @Test
    public void testE() {
        assertEquals("E is not calculated correctly", 9, magicNumbers.calculateE());
    }

    @Test
    public void testADependsOnName() {
        int first = magicNumbers.calculateA();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different names", first, second);
    }

    @Test
    public void testADependsOnAge() {
        int first = magicNumbers.calculateA();
        magicNumbers.setAge(18);
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different ages", first, second);
    }

    @Test
    public void testBDependsOnLocation() {
        int first = magicNumbers.calculateB();
        magicNumbers.setLocation("Grytevik");
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different locations", first, second);
    }

    @Test
    public void testBDependsOnIncome() {
        int first = magicNumbers.calculateB();
        magicNumbers.setIncome(219487);
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different income values", first, second);
    }

    @Test
    public void testCDependsOnHeight() {
        int first = magicNumbers.calculateC();
        magicNumbers.setHeight(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different heights", first, second);
    }

    @Test
    public void testCDependsOnAge() {
        int first = magicNumbers.calculateC();
        magicNumbers.setAge(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different ages", first, second);
    }

    @Test
    public void testCDependsOnName() {
        int first = magicNumbers.calculateC();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different names", first, second);
    }
}
